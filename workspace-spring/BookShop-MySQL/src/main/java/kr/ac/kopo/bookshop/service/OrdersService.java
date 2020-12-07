package kr.ac.kopo.bookshop.service;

import java.util.List;
import java.util.Map;

import kr.ac.kopo.bookshop.model.Book;
import kr.ac.kopo.bookshop.model.Customer;
import kr.ac.kopo.bookshop.model.Orders;
import kr.ac.kopo.bookshop.util.Pager;

public interface OrdersService {

	List<Orders> list(Pager pager);

	void add(Orders item);

	Orders item(int orderid);

	void update(Orders item);

	void delete(int orderid);

	void order(Customer customer, Map<Integer, Book> cart);

}
