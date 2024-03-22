package com.jpa.demo.service;

import com.jpa.demo.model.Account;
import com.jpa.demo.remote.RepositoryAcct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//repo..accct import
import java.util.List;

@Service
public class AccountService {
    @Autowired
    RepositoryAcct accountRepository;

    public Account callSave(Account account) {
        return accountRepository.save(account);
    }

    public List<Account> callFindAll() {
        return (List<Account>) accountRepository.findAll();
    }
}
