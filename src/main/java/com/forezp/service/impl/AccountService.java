package com.forezp.service.impl;

import com.forezp.dao.IAccountDAO;
import com.forezp.entity.Account;
import com.forezp.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TODO
 * @author msh
 * @time 2017/11/23 20:55
 */
@Service
public class AccountService implements IAccountService {
    @Autowired
    IAccountDAO accountDAO;
    @Override
    public int add(Account account) {
        return accountDAO.add(account);
    }

    @Override
    public int update(Account account) {
        return accountDAO.update(account);
    }

    @Override
    public int delete(int id) {
        return accountDAO.delete(id);
    }

    @Override
    public Account findAccountById(int id) {
        return accountDAO.findAccountById(id);
    }

    @Override
    public List<Account> findAccountList() {
        return accountDAO.findAccountList();
    }

}
