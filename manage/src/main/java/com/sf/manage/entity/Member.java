package com.sf.manage.entity;

import com.sf.manage.enums.MemberType;
import lombok.Data;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "m_member")
public class Member {
    /**
     * 会员id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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
    /**
     * 用户类型
     */
    @Enumerated(EnumType.STRING)
    private MemberType type;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    @Transient
    private Wallet wallet;
}
