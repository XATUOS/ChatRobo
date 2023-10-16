package dev.xatuos.chatrobo.impl.events;

import dev.xatuos.chatrobo.ChatRobo;
import dev.xatuos.chatrobo.api.events.Event;
import dev.xatuos.chatrobo.api.events.IEventBus;
import dev.xatuos.chatrobo.api.events.SubscribeEvent;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

public class EventBus implements IEventBus {
    private final Map<Class<? extends Event>, Map<String, List<IEventListener>>> listeners;

    public EventBus() {
        this.listeners = new ConcurrentHashMap<>();
    }

    @Override
    public void register(@NotNull String namespace, @NotNull Class<? extends Event> event, @NotNull IEventListener listener) {
        Map<String, List<IEventListener>> listeners = this.listeners.getOrDefault(event, new ConcurrentHashMap<>());
        List<IEventListener> listenerList = listeners.getOrDefault(namespace, new Vector<>());
        listenerList.add(listener);
        if (!listeners.containsKey(namespace)) listeners.put(namespace, listenerList);
        if (!this.listeners.containsKey(event)) this.listeners.put(event, listeners);
    }

    @Override
    public void register(@NotNull String namespace, @NotNull Object listener) {
        Method[] methods = listener.getClass().getMethods();
        for (Method method : methods) {
            if (method.getAnnotation(SubscribeEvent.class) == null) continue;
            if (method.getParameterCount() != 1) continue;
            if (Event.class.isAssignableFrom(method.getParameterTypes()[0])) continue;
            Class<?> clazz = method.getParameterTypes()[0];
            if (!(clazz.isAssignableFrom(Event.class))) continue;
            Class<? extends Event> event = clazz.asSubclass(Event.class);
            this.register(namespace, event, (event1) -> {
                try {
                    method.invoke(listener, event1);
                } catch (IllegalAccessException | InvocationTargetException exception) {
                    ChatRobo.LOGGER.printStackTrace(exception);
                }
            });
        }
    }

    @Override
    public void call(@NotNull Event event) {
        Map<String, List<IEventListener>> listeners = this.listeners.getOrDefault(event.getClass(), null);
        if (listeners == null) return;
        for (List<IEventListener> listenerList : listeners.values()) {
            for (IEventListener listener : listenerList) {
                listener.call(event);
            }
        }
    }
}
