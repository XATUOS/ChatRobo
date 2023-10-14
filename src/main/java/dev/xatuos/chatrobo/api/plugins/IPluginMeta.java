package dev.xatuos.chatrobo.api.plugins;

import dev.xatuos.chatrobo.api.util.IVersion;

import java.util.List;
import java.util.Map;

public interface IPluginMeta {
    /**
     * 获取插件ID
     *
     * @return 插件ID
     */
    String getId();

    /**
     * 获取插件名称
     *
     * @return 插件名称
     */
    String getName();

    /**
     * 获取插件版本
     *
     * @return 插件版本
     */
    IVersion getVersion();

    /**
     * 获取插件描述
     *
     * @return 插件描述
     */
    String getDescription();

    /**
     * 获取插件依赖
     *
     * @return 插件依赖
     */
    Map<String, String> getDepends();

    /**
     * 获取插件主类
     *
     * @return 插件主类
     */
    String getMainClass();

    /**
     * 获取插件作者
     *
     * @return 插件作者
     */
    List<String> getAuthor();

    /**
     * 获取插件网站
     *
     * @return 插件网站
     */
    String getWebsite();

    /**
     * 获取插件反馈地址
     *
     * @return 插件反馈地址
     */
    String getIssue();

    /**
     * 获取插件开源地址
     *
     * @return 插件开源地址
     */
    String getSource();
}
