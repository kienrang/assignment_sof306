package com.sof306.assignment.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sof306.assignment.entity.Account;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, String> {
    @Query("select distinct a.account from Authority a where a.role.id in ('DIRE','STAF')")
    List<Account> getAdmin();
}