package kr.ac.kopo.bookshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.bookshop.dao.OrdersDao;
import kr.ac.kopo.bookshop.model.Orders;
import kr.ac.kopo.bookshop.model.Pager;

@Service
public class OrdersServiceImpl implements OrdersService {

	@Autowired
	OrdersDao dao;
	
	@Override
	public List<Orders> list(Pager pager) {
		int total = dao.total(pager);
		pager.setTotal(total);
		return dao.list(pager);
	}

	@Override
	public void add(Orders item) {
		dao.add(item);
	}

	@Override
	public Orders item(int orderid) {
		return dao.item(orderid);
	}

	@Override
	public void update(Orders item) {
		dao.update(item);
	}

	@Override
	public void delete(int orderid) {
		dao.delete(orderid);
	}

}
