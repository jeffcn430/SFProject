package com.sf.manage.service;

import com.sf.manage.entity.Member;
import com.sf.manage.utils.LayTableParams;
import org.springframework.data.domain.Page;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface IMemberService {
    /**
     * 获取会员列表
     *
     * @param member    会员条件
     * @param startTime 开始时间
     * @param endTime   结束时间
     * @param params    laytable参数
     * @return
     */
    Page<Member> getMemberPage(Member member, LocalDate startTime, LocalDate endTime, LayTableParams params);

    /**
     * 通过账号获取会员信息
     * @param account 会员账号
     * @return
     */
    Member getMemberById(String account);
}
