package com.sf.manage.repository;

import com.sf.manage.entity.Member;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long>, JpaSpecificationExecutor<Member> {
    /**
     * 通过账号获取会员信息
     *
     * @param account 会员账号
     * @return
     */
    @Cacheable(cacheNames = "cache")
    Member findByAccount(String account);
}
