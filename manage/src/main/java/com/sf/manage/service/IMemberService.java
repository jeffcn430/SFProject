package com.sf.manage.service;

import com.sf.manage.entity.Member;
import com.sf.manage.utils.LayTableParams;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

public interface IMemberService {
    /**
     * 获取会员列表
     *
     * @param member    会员条件
     * @param params    laytable参数
     * @return
     */
//    @Transactional(readOnly = true)
    Page<Member> getMemberPage(Member member, LayTableParams params);

    /**
     * 通过账号获取会员信息
     * @param account 会员账号
     * @return
     */
    Member getMemberById(String account);

    Member addMember(Member member);
}
