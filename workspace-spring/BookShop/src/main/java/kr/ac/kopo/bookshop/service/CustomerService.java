package kr.ac.kopo.bookshop.service;

import java.util.List;

import kr.ac.kopo.bookshop.model.Customer;
import kr.ac.kopo.bookshop.model.Pager;

public interface CustomerService {

	boolean login(Customer item);

	List<Customer> list(Pager pager);

	void add(Customer item);

	Customer item(int custid);

	void update(Customer item);

	void delete(int custid);

	int checkId(String id);

}
