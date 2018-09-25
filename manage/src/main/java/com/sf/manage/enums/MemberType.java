package com.sf.manage.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

import java.util.Arrays;

/**
 * 用户类型
 */
@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum MemberType {
    all(0, "全部"),
    agent(1, "代理"),
    MEMBER(2, "会员"),
    TEST(99, "测试会员");

    private Integer code;
    private String name;

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    MemberType(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public static MemberType getEnum(String key) {
        return Arrays.stream(MemberType.values()).filter(o -> o.code == Integer.parseInt(key)).findFirst().get();
    }
}
