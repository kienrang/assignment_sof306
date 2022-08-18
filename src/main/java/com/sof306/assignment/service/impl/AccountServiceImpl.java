package com.sof306.assignment.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sof306.assignment.dao.AccountRepository;
import com.sof306.assignment.entity.Account;
import com.sof306.assignment.service.AccountService;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountRepository accountRepository;

    @Override
    public Account findById(String username) {
        return this.accountRepository.getAccount(username);
    }

    @Override
    public List<Account> getAdmin() {
        return this.accountRepository.getAdmin();
    }

    @Override
    public List<Account> findAll() {
        return this.accountRepository.findAll();
    }

    @Override
    public Account create(Account acc) {
        return this.accountRepository.save(acc);
    }

    @Override
    public Account update(Account acc) {
        return this.accountRepository.save(acc);
    }

    @Override
    public void delete(Account acc) {
        this.accountRepository.delete(acc);
    }
}
