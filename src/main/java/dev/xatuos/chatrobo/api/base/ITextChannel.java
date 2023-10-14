package dev.xatuos.chatrobo.api.base;

import java.util.List;

public interface ITextChannel extends IContact {
    /**
     * 获取用户列表
     * @return 用户列表
     */
    List<IUser> getUsers();
}
