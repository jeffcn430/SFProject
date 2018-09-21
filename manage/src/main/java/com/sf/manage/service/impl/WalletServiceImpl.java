package com.sf.manage.service.impl;

import com.sf.manage.entity.Cash;
import com.sf.manage.entity.Wallet;
import com.sf.manage.repository.WalletRepository;
import com.sf.manage.service.IWalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WalletServiceImpl implements IWalletService {
    @Autowired
    private WalletRepository walletRepository;

    @Override
    public Wallet getWalletById(int id) {
        return this.walletRepository.findByMemberId(id);
    }

    @Override
    public Wallet update() {
        Wallet wallet = this.walletRepository.findByMemberId(1);
        wallet.setMemberId(21212121);
        for (Cash cash : wallet.getCashs()) {
            cash.setTxt("222233333");
        }
        return this.walletRepository.save(wallet);
    }


}
