package service;
import java.util.List;

import domain.Account;

public interface AccountService {

    // ��ѯ�����˻�
    public List<Account> findAll();

    // �����ʻ���Ϣ
    public void saveAccount(Account account);

}