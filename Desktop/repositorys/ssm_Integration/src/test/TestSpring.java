package test;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import service.AccountService;

public class TestSpring {

   public static void main(String[] args){
        // ���������ļ�
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        // ��ȡ����
        AccountService as = (AccountService) ac.getBean("accountService");
        // ���÷���
        as.findAll();
    }

}
