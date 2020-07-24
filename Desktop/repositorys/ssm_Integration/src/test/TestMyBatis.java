package test;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import dao.AccountDao;
import domain.Account;

public class TestMyBatis {


	public static void main(String[] args) throws Exception {
        // ���������ļ�
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        // ����SqlSessionFactory����
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        // ����SqlSession����
        SqlSession session = factory.openSession();
        // ��ȡ���������
        AccountDao dao = session.getMapper(AccountDao.class);
        // ��ѯ��������
        List<Account> list = dao.findAll();
        for(Account account : list){
            System.out.println(account);
        }
        // �ر���Դ
        session.close();
        in.close();
    }

//    @Test
//    public void run2() throws Exception {
//        Account account = new Account();
//        account.setName("�ܴ�");
//        account.setMoney(400d);
//
//        // ���������ļ�
//        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
//        // ����SqlSessionFactory����
//        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
//        // ����SqlSession����
//        SqlSession session = factory.openSession();
//        // ��ȡ���������
//        AccountDao dao = session.getMapper(AccountDao.class);
//
//        // ����
//        dao.saveAccount(account);
//
//        // �ύ����
//        session.commit();
//
//        // �ر���Դ
//        session.close();
//        in.close();
//    }

}
