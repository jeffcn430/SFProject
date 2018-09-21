package com.sf.manage.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Data
@Entity
@Table(name = "m_member")
public class Member {
    /**
     * 会员id
     */
    @Id
    private long id;
    /**
     * 会员账号
     */
    private String account;
    /**
     * 会员密码
     */
    private String password;
    /**
     * 会员昵称
     */
    private String nick;

    @Transient
    private Wallet wallet;
}
