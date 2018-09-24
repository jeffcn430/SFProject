package com.sf.manage.enums;

import lombok.Getter;

/**
 * 用户类型
 */
@Getter
public enum MemberType {
    agent(1, "代理"),
    MEMBER(2, "会员"),
    TEST(99, "测试会员");

    private Integer code;
    private String name;

    MemberType(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    @Override
    public String toString() {
        return "{code: " + code + ","
                + "name:'" + name + "'}";
    }
}
