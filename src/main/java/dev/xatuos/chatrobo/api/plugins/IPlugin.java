package dev.xatuos.chatrobo.api.plugins;

public interface IPlugin {
    /**
     * 获取插件ID
     *
     * @return 插件ID
     */
    String getID();

    /**
     * 获取插件元数据
     *
     * @return 插件元数据
     */
    IPluginMeta getMeta();

    /**
     * 初始化插件时执行
     */
    void initialization();

    /**
     * 卸载插件时执行
     */
    void uninstall();
}
