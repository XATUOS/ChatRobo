package dev.xatuos.chatrobo.api.logging;

import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface ILogger extends Logger {
    StackWalker STACK_WALKER = StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE);

    default void printStackTrace(@NotNull Exception exception) {
        this.error(exception + ":");
        StackTraceElement[] traces = exception.getStackTrace();
        for (StackTraceElement trace : traces) {
            this.error(trace.toString());
        }
    }

    static ILogger getLogger() {
        return new dev.xatuos.chatrobo.impl.logging.Logger(LoggerFactory.getLogger(STACK_WALKER.getCallerClass()));
    }
}
