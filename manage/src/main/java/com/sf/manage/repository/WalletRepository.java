package com.sf.manage.repository;

import com.sf.manage.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, Integer> {
    /**
     * 通过会员id获取钱包
     * @param memberId
     * @return
     */
    Wallet findByMemberId(long memberId);
}
