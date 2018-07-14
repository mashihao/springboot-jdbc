package com.forezp.dao;

import com.forezp.entity.Account;

import java.util.List;

/**
 * TODO
 * @author msh
 * @time 2017/11/23 20:55
 */
public interface IAccountDAO {
    int add(Account account);

    int update(Account account);

    int delete(int id);

    Account findAccountById(int id);

    List<Account> findAccountList();
}
