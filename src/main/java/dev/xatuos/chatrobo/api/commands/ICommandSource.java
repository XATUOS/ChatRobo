package dev.xatuos.chatrobo.api.commands;

import dev.xatuos.chatrobo.api.base.IContact;
import dev.xatuos.chatrobo.api.base.chat.IComponent;

public interface ICommandSource extends IContact {
    /**
     * @return 是否接收命令执行失败消息
     */
    boolean acceptsFailure();

    /**
     * @return 是否接收命令执行成功消息
     */
    boolean acceptsSuccess();

    /**
     * 发送命令成功消息
     *
     * @param msg 消息
     */
    default void sendSuccess(IComponent msg) {
        if (this.acceptsSuccess()) this.send(msg);
    }

    /**
     * 发送命令失败消息
     *
     * @param msg 消息
     */
    default void sendFailure(IComponent msg) {
        if (this.acceptsFailure()) this.send(msg);
    }
}
