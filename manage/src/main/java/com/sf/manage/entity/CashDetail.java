package com.sf.manage.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "cash_detail")
public class CashDetail {
    /**
     * 资金流水号
     */
    @Id
    private Long id;
    /**
     * 会员id
     */
    private Long memberId;
    /**
     * 站点id
     */
    private Integer siteId;
    /**
     * 交易大类型
     */
    private Integer type;
    /**
     * 交易小类型
     */
    private Integer smallType;
    /**
     * 交易金额
     */
    private BigDecimal moeny;
    /**
     * 交易前金额
     */
    private BigDecimal beforeMoney;
    /**
     * 交易后金额
     */
    private BigDecimal laterMoney;
}
