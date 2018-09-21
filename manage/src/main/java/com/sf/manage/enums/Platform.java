package com.sf.manage.enums;

import lombok.Getter;

@Getter
public enum Platform {
    main(1, "name");

    private Integer code;
    private String name;

    Platform(Integer code, String name) {
        this.code = code;
        this.name = name;
    }
}
