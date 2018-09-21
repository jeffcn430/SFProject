package com.sf.manage.service;


import com.sf.manage.entity.Wallet;

public interface IWalletService {
    Wallet getWalletById(int id);

    Wallet update();
}
