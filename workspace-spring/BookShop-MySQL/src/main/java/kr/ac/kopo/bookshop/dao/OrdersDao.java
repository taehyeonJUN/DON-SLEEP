package kr.ac.kopo.bookshop.dao;

import java.util.List;

import kr.ac.kopo.bookshop.model.Orders;
import kr.ac.kopo.bookshop.util.Pager;

public interface OrdersDao {

	int total(Pager pager);

	List<Orders> list(Pager pager);

	void add(Orders item);

	Orders item(int orderid);

	void update(Orders item);

	void delete(int orderid);

}
