package service.impl;

import com.github.pagehelper.PageHelper;
import dao.IOrdersDao;
import domain.Orders;
import service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrdersServiceImpl implements IOrdersService {

    @Autowired
    private IOrdersDao ordersDao;

    @Override
    public List<Orders> findAll(int page, int size) throws Exception {

        //����pageNum ��ҳ��ֵ   ����pageSize ������ÿҳ��ʾ����
        PageHelper.startPage(page, size);
        return ordersDao.findAll();
    }

    @Override
    public Orders findById(String ordersId) throws Exception{
        return ordersDao.findById(ordersId);
    }
}