package com.sf.manage.service.impl;

import com.sf.manage.entity.Wallet;
import com.sf.manage.enums.PaymentType;
import com.sf.manage.enums.Platform;
import com.sf.manage.repository.WalletRepository;
import com.sf.manage.service.IWalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class WalletServiceImpl implements IWalletService {
    @Autowired
    private WalletRepository walletRepository;

    @Override
    public Wallet getWalletById(int id) {
        return this.walletRepository.findByMemberId(id);
    }

    @Override
    public boolean onlineRecharge(Long memberId, PaymentType pt, BigDecimal money) {
        return false;
    }

    @Override
    public boolean offlineRecharge(Long memberId, PaymentType pt, BigDecimal money) {
        return false;
    }

    @Override
    public boolean platformTransfer(Platform pf, Platform tpf, BigDecimal money) {
        return false;
    }
}
