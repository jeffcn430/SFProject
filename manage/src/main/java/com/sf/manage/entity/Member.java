package com.sf.manage.entity;

import com.sf.manage.enums.MemberStatus;
import com.sf.manage.enums.MemberType;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.time.LocalDate;
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
     * 用户状态
     */
    @Enumerated(EnumType.STRING)
    private MemberStatus status = MemberStatus.normal;
    /**
     * 注册时间
     */
    private LocalDateTime createTime = LocalDateTime.now();
    /**
     * 最后登陆时间
     */
    private LocalDateTime lastLoginTime = LocalDateTime.now();
    /**
     * 登陆次数
     */
    private Integer loginNum = 0;

    @Transient
    private Wallet wallet;

    @Data
    public static class MemberListParams {
        /**
         * 账号条件
         */
        private String account;
        /**
         * 是否模糊查询账号
         */
        private Integer isLike;
        /**
         * 会员类型
         */
        private String type;
        /**
         * 会员状态
         */
        private String status;
        /**
         * 开始时间
         */
        private LocalDate startTime;
        /**
         * 结束时间
         */
        private LocalDate endTime;
    }
}
