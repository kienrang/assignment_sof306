package com.sof306.assignment.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.sof306.assignment.entity.Account;
import com.sof306.assignment.service.AccountService;

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
    public Account insert(@RequestBody Account acc) {
        return this.accountService.create(acc);
    }

    @PutMapping("/{username}")
    public Account update(@PathVariable("String") String username, @RequestBody Account acc) {
        System.out.println("Cũ ----------" + this.accountService.findById(username).toString());
        System.out.println("Mới--------------" + acc.toString());

        return null;
    }

    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Integer id) {
        return 1;
    }
}
