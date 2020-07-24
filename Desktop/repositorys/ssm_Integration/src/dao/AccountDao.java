package dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import domain.Account;

/**
 * �ʻ�dao�ӿ�
 */
@Repository
public interface AccountDao {

    // ��ѯ�����˻�
    @Select("select * from account")
    public List<Account> findAll();

    // �����ʻ���Ϣ
    @Insert("insert into account (name,money) values (#{name},#{money})")
    public void saveAccount(Account account);

}