package dev.xatuos.chatrobo.api.util;

import org.jetbrains.annotations.NotNull;

import java.io.Reader;

public interface ILoadable<T> {

    /**
     * 加载数据
     *
     * @param reader 数据读取器
     * @return 加载的数据
     */
    @NotNull
    T load(@NotNull Reader reader);
}
