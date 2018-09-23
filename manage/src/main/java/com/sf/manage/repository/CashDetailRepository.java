package com.sf.manage.repository;

import com.sf.manage.entity.CashDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CashDetailRepository extends JpaRepository<CashDetail, Long> {
}
