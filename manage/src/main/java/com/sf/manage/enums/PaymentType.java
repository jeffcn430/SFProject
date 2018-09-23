package com.sf.manage.enums;

import lombok.Getter;

/**
 * 充值类型
 */
@Getter
public enum PaymentType {
    qq_pay(1, 1, "线上"),
    offlline(1, 1, "");

    /**
     * 支付类型id
     */
    private Integer code;
    /**
     * 支付方式:1:线上,2:线下,3:人工
     */
    private Integer type;
    /**
     * 支付类型名称
     */
    private String name;

    PaymentType(Integer code, Integer type, String name) {
        this.code = code;
        this.type = type;
        this.name = name;
    }
}
