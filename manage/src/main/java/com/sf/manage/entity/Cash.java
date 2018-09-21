package com.sf.manage.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "m_cash")
public class Cash {
    /**
     * 流水id
     */
    @Id
    private int id;
    /**
     * 钱包id
     */
    private long walletId;

    private String txt;

}
