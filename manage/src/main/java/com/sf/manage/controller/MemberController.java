package com.sf.manage.controller;

import com.sf.manage.entity.Member;
import com.sf.manage.service.IMemberService;
import com.sf.manage.utils.JsonResult;
import com.sf.manage.utils.LayTableParams;
import com.sf.manage.utils.LayTableReturn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("member")
public class MemberController {
    @Autowired
    private IMemberService memberService;

    /**
     * 获取会员列表
     *
     * @param member    会员条件
     * @param startTime 开始时间
     * @param endTime   结束时间
     * @param params    laytable参数
     * @return
     */
    @GetMapping("")
    public LayTableReturn getMemberPage(Member member, LocalDate startTime, LocalDate endTime, LayTableParams params) {
        return new LayTableReturn(memberService.getMemberPage(member, startTime, endTime, params));
    }

    @GetMapping("{account}")
    public JsonResult getMemberById(@PathVariable String account){
        return new JsonResult(this.memberService.getMemberById(account));
    }
}
