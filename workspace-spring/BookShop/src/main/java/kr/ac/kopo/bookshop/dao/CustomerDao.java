package kr.ac.kopo.bookshop.dao;

import java.util.List;

import kr.ac.kopo.bookshop.model.Customer;
import kr.ac.kopo.bookshop.model.Pager;

public interface CustomerDao {


	//int로 처리하고 로그인이 1이면 true처리
	int login(Customer item);

	List<Customer> list(Pager pager);

	void add(Customer item);

	void update(Customer item);

	void delete(int custid);

	Customer item(int custid);

	int total(Pager pager);

	int checkId(String id);
	
}
