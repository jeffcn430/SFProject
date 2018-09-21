package com.sf.manage.controller;

import com.sf.manage.service.IWalletService;
import com.sf.manage.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("wallet")
public class WalletController {
    @Autowired
    private IWalletService walletService;

    @GetMapping("{id}")
    public JsonResult getWalletById(@PathVariable int id) {
        return new JsonResult(walletService.getWalletById(id));
    }

    @GetMapping("")
    public JsonResult getWalletById1() {
        return new JsonResult(walletService.update());
    }


}