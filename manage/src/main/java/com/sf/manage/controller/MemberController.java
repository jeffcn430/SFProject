package com.sf.manage.controller;

import com.sf.manage.entity.Member;
import com.sf.manage.enums.MemberType;
import com.sf.manage.service.IMemberService;
import com.sf.manage.utils.JsonResult;
import com.sf.manage.utils.LayTableParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RestController
@RequestMapping("member")
public class MemberController {
    @Autowired
    private IMemberService memberService;

    /**
     * 获取会员列表
     *
     * @param member    会员条件
     * @param params    laytable参数
     * @return
     */
    @GetMapping("")
    public JsonResult getMemberPage(Member member, LayTableParams params) {
        return new JsonResult(memberService.getMemberPage(member, params));
    }

    @GetMapping("{account}")
    public JsonResult getMemberById(@PathVariable String account) {
        return new JsonResult(this.memberService.getMemberById(account));
    }

    @GetMapping("add")
    public JsonResult addMember() {
        Member member = new Member();
        member.setNick("jeff");
        member.setAccount("jeff001");
        member.setPassword("qwe123");
        member.setType(MemberType.AGENT);
        member.setCreateTime(LocalDateTime.now());
        return new JsonResult(this.memberService.addMember(member));
    }
}
