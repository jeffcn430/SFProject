package com.sf.manage.enums;

import lombok.Getter;

@Getter
public enum ResultStatus {
    SUCCESS(0, "成功");

    private int code;
    private String msg;

    ResultStatus(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
