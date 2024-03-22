package com.jpa.demo.controller;

import com.jpa.demo.model.Account;
import com.jpa.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/account")
public class RestApi {

    @Autowired
    AccountService accountService;

  //save
    @PostMapping("/")
    public Account apiSave(@RequestBody Account account) {
        return accountService.callSave(account);
    }

   //update
    @PutMapping("/")
    public Account apiUpdate(@RequestBody Account account) {
        return accountService.callSave(account);
    }

   //find
    @GetMapping("/")
    public List<Account> apiFindAll() {
        return accountService.callFindAll();
    }

}
