package service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.AccountDao;
import domain.Account;
import service.AccountService;

@Service("accountService")
public class AccountServiceImpl implements AccountService{

    @Autowired
    private AccountDao accountDao;

    public List<Account> findAll() {
        System.out.println("ҵ��㣺��ѯ�����˻�...");
        return accountDao.findAll();
    }

    public void saveAccount(Account account) {
        System.out.println("ҵ��㣺�����ʻ�...");
        accountDao.saveAccount(account);
    }
}