package dev.xatuos.chatrobo.api.events;

import org.jetbrains.annotations.NotNull;

public interface IEventBus {
    /**
     * 注册事件监听器
     *
     * @param namespace 命名空间
     * @param event     事件类型
     * @param listener  事件监听器
     */
    void register(@NotNull String namespace, @NotNull Class<? extends Event> event, @NotNull IEventListener listener);

    /**
     * 注册事件监听器
     *
     * @param namespace 命名空间
     * @param listener  事件监听器
     */
    void register(@NotNull String namespace, @NotNull Object listener);

    /**
     * 发布事件
     *
     * @param event 事件
     */
    void call(@NotNull Event event);

    @FunctionalInterface
    interface IEventListener {
        void call(Event event);
    }
}
