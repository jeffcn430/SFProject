package com.sf.manage.service.impl;

import com.sf.manage.entity.Member;
import com.sf.manage.service.IMemberService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements IMemberService {

    @Override
    public Page<Member> getMemberPage(Sort sort) {
        return null;
    }
}
