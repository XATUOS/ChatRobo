package dev.xatuos.chatrobo.api.commands;

public interface ICommandManager<S> {
    int performCommand(S source, String string);

    default int performPrefixedCommand(S source, String string) {
        string = string.startsWith("/") ? string.substring(1) : string;
        return this.performCommand(source, string);
    }
}
