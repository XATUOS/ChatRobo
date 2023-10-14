package dev.xatuos.chatrobo.api.commands;


import java.io.StringReader;
import java.util.Collection;
import java.util.Collections;

public interface ArgumentType<T> {
    /**
     * 解析参数
     *
     * @param reader 字符串reader
     * @return 解析参数值
     */
    T parse(StringReader reader);

    /**
     * 获取示例
     *
     * @return 示例
     */
    default Collection<String> getExamples() {
        return Collections.emptyList();
    }
}
