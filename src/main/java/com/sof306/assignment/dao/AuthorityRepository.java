package com.sof306.assignment.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.sof306.assignment.entity.Account;
import com.sof306.assignment.entity.Authority;

import java.util.List;

public interface AuthorityRepository extends JpaRepository<Authority, Integer> {
    @Query("SELECT DISTINCT a from  Authority a where a.account in ?1")
    List<Authority> authorities(List<Account> accounts);
}