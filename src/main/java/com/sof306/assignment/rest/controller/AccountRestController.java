package com.sof306.assignment.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.sof306.assignment.entity.Account;
import com.sof306.assignment.entity.Authority;
import com.sof306.assignment.entity.Role;
import com.sof306.assignment.service.AccountService;
import com.sof306.assignment.service.AuthorityService;
import com.sof306.assignment.service.RoleService;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/accounts")
public class AccountRestController {
    @Autowired
    AccountService accountService;

    @GetMapping
    public List<Account> getAll(@RequestParam("admin") Optional<Boolean> admin) {
        if (admin.orElse(false)) {
            return accountService.getAdmin();
        }
        return accountService.findAll();
    }

    @PostMapping
    public Account insert(@RequestBody Account account) {
        return this.accountService.create(account);
    }

    @PutMapping("/{user}")
    public Account update(@PathVariable("user") String username, @RequestBody Account account) {
        Account acc = new Account();
        acc.setUsername(account.getUsername());
        acc.setEmail(account.getEmail());
        acc.setFullname(account.getFullname());
        acc.setPassword(account.getPassword());
        acc.setPhoto(account.getPhoto());
        acc.setOrders(account.getOrders());
        acc.setAuthorities(account.getAuthorities());
        return this.accountService.update(acc);
    }

    @DeleteMapping("/{user}")
    public int delete(@PathVariable("user") String user) {
        this.accountService.delete(this.accountService.findById(user));
        return 1;
    }
}
