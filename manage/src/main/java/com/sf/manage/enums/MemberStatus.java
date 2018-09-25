package com.sf.manage.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

import java.util.Arrays;

@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum MemberStatus {
    all(0, "全部"),
    normal(1, "正常"),
    inactive(2, "未激活");

    private Integer code;
    private String name;

    MemberStatus(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public static MemberStatus getEnum(String key) {
        return Arrays.stream(MemberStatus.values()).filter(o -> o.code == Integer.parseInt(key)).findFirst().get();
    }
}
