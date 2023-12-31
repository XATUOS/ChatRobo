package dev.xatuos.chatrobo.api.base;

import dev.xatuos.chatrobo.api.base.chat.IComponent;

public interface IContact {
    /**
     * 获取联系人ID
     *
     * @return 联系人ID
     */
    Long getId();

    /**
     * 发送聊天组件
     *
     * @param component 聊天组件
     */
    void send(IComponent component);
}
