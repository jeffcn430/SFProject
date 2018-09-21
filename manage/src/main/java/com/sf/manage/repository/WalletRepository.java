package com.sf.manage.repository;

import com.sf.manage.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, Integer> {
    //    @Cacheable(cacheNames="")
    Wallet findByMemberId(long memberId);

    //    @Cacheable(cacheNames="2121")
}
