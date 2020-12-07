package kr.ac.kopo.bookshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.bookshop.dao.CustomerDao;
import kr.ac.kopo.bookshop.model.Customer;
import kr.ac.kopo.bookshop.util.Pager;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	CustomerDao dao;

	@Override
	public List<Customer> list(Pager pager) {
		int total = dao.total(pager);
		
		pager.setTotal(total);
		
		return dao.list(pager);
	}

	@Override
	public void add(Customer item) {
		dao.add(item);
	}

	@Override
	public Customer item(int custid) {
		return dao.item(custid);
	}

	@Override
	public void update(Customer item) {
		dao.update(item);
	}

	@Override
	public void delete(int custid) {
		dao.delete(custid);
	}

	@Override
	public boolean login(Customer item) {
		Customer customer = dao.login(item);
		if(customer == null) 
			return false;
		
		item.setCustid( customer.getCustid() );
		item.setAddress( customer.getAddress() );
		
		return true;
	}

	@Override
	public int checkId(String id) {
		return dao.checkId(id);
	}

}
