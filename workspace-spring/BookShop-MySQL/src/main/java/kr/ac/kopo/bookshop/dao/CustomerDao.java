package kr.ac.kopo.bookshop.dao;

import java.util.List;

import kr.ac.kopo.bookshop.model.Customer;
import kr.ac.kopo.bookshop.util.Pager;

public interface CustomerDao {

	int total(Pager pager);

	List<Customer> list(Pager pager);

	void add(Customer item);

	Customer item(int custid);

	void update(Customer item);

	void delete(int custid);

	Customer login(Customer item);

	int checkId(String id);

}
