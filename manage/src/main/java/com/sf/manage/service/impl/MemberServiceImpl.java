package com.sf.manage.service.impl;

import com.sf.manage.entity.Member;
import com.sf.manage.repository.MemberRepository;
import com.sf.manage.service.IMemberService;
import com.sf.manage.utils.LayTableParams;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Predicate;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class MemberServiceImpl implements IMemberService {
    @Autowired
    private MemberRepository memberRepository;

    @Override
    public Page<Member> getMemberPage(Member.MemberListParams member, LayTableParams params) {
        //构造查询条件
        Specification<Member> spec = (Specification<Member>) (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            // 大于起始时间
            if (!StringUtils.isEmpty(member.getStartTime())) {
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("createTime").as(LocalDate.class), member.getStartTime()));
            }
            // 小于结束时间
            if (!StringUtils.isEmpty(member.getStartTime())) {
                predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("createTime").as(LocalDate.class), member.getEndTime()));
            }
            // 会员类型
            if (!StringUtils.isEmpty(member.getType())) {
                predicates.add(criteriaBuilder.equal(root.get("type"), member.getType()));
            }
            // 会员类型
            if (!StringUtils.isEmpty(member.getStatus())) {
                predicates.add(criteriaBuilder.equal(root.get("status"), member.getStatus()));
            }
            // 会员账号
            if (!StringUtils.isEmpty(member.getAccount())) {
                if (member.getIsLike() == 1) {
                    predicates.add(criteriaBuilder.equal(root.get("account"), member.getAccount()));
                } else if (member.getIsLike() == 2) {
                    predicates.add(criteriaBuilder.like(root.get("account"), member.getAccount()));
                }
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

    @Override
    public Member addMember(Member member) {
        return this.memberRepository.save(member);
    }

    @Override
    public List<Member> getMemberList() {
        return this.memberRepository.findAll();
    }
}
