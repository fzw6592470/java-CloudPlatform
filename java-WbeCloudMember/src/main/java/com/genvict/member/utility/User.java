package com.genvict.member.utility;

import lombok.Getter;
import lombok.Setter;

public class User {
    private static final long serialVersionUID = 1L;

    // ========================================================================
    // fields =================================================================
    @Getter @Setter private String loginName;                                   // 用户登陆名称
    @Getter @Setter private String name;                                        // 用户姓名
    @Getter @Setter private String avatar;                                      // 用户头像
    @Getter @Setter private String memos;                                       // 信息备注

    // ========================================================================
    // constructor ============================================================
    public User() {
    }

    public User(String loginName, String name, String avatar, String memos) {
        this.loginName = loginName;
        this.name = name;
        this.avatar = avatar;
        this.memos = memos;
    }
}
