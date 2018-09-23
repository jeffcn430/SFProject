package com.sf.manage.service;


import com.sf.manage.entity.Wallet;
import com.sf.manage.enums.PaymentType;
import com.sf.manage.enums.Platform;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

public interface IWalletService {
    /**
     * 通过会员id获取会员钱包
     *
     * @param id
     * @return
     */
    Wallet getWalletById(int id);

    /**
     * 线上充值
     * @param memberId 会员id
     * @param pt 支付类型
     * @param money 充值金额
     * @return
     */
    @Transactional()
    boolean onlineRecharge(Long memberId, PaymentType pt, BigDecimal money);

    /**
     * 线下充值
     * @param memberId 会员id
     * @param pt 支付类型
     * @param money 充值金额
     * @return
     */
    @Transactional
    boolean offlineRecharge(Long memberId, PaymentType pt, BigDecimal money);

    /**
     * 平台转账
     * @param pf
     * @param tpf
     * @param money
     * @return
     */
    @Transactional
    boolean platformTransfer(Platform pf, Platform tpf, BigDecimal money);
}
