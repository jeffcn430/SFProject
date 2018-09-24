package com.sf.manage.enums;

import lombok.Getter;

@Getter
public enum MemberStatus {
    normal(1, "正常"),
    inactive(2, "未激活");

    private Integer code;
    private String name;

    MemberStatus(Integer code, String name){
        this.code = code;
        this.name = name;
    }
}
