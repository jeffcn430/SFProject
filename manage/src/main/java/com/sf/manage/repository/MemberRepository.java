package com.sf.manage.repository;

import com.sf.manage.entity.Member;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    //分类查询
    @Cacheable(cacheNames = {"redis_key"}, key="member")
    List<Member> findAll(Sort sort);
    //分页查询
    Page<Member> findAll(Pageable pageable);

}
