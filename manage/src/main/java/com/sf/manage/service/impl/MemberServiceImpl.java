package com.sf.manage.service.impl;

import com.sf.manage.entity.Member;
import com.sf.manage.repository.MemberRepository;
import com.sf.manage.service.IMemberService;
import com.sf.manage.utils.LayTableParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Predicate;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class MemberServiceImpl implements IMemberService {
    @Autowired
    private MemberRepository memberRepository;

    @Override
    public Page<Member> getMemberPage(Member member, LocalDate startTime, LocalDate endTime, LayTableParams params) {

        //构造查询条件
        Specification<Member> spec = (Specification<Member>) (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            // 会员创建时间范围
            predicates.add(criteriaBuilder.between(root.get("createTime").as(LocalDate.class), startTime, endTime));
            // 会员账号
            if (!StringUtils.isEmpty(member.getAccount())) {
                predicates.add(criteriaBuilder.equal(root.get("account"), member.getAccount()));
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
        };
        // 分页查询会员列表并返回
        return this.memberRepository.findAll(spec, params.getPageable());
    }

    @Override
    public Member getMemberById(String account) {
        return this.memberRepository.findByAccount(account);
    }
}
