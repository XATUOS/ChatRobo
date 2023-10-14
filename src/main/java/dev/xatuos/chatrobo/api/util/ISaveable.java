package dev.xatuos.chatrobo.api.util;

import org.jetbrains.annotations.NotNull;

public interface ISaveable {
    /**
     * 保存数据
     *
     * @param writer 数据写入器
     */
    void save(@NotNull Appendable writer);
}
