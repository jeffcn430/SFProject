package com.sf.manage.service;

import com.sf.manage.entity.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

public interface IMemberService {
    Page<Member> getMemberPage(Sort sort);
}
