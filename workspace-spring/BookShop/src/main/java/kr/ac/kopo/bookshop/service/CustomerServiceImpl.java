package kr.ac.kopo.bookshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.bookshop.dao.CustomerDao;
import kr.ac.kopo.bookshop.model.Customer;
import kr.ac.kopo.bookshop.model.Pager;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	CustomerDao dao;

	@Override
	public boolean login(Customer item) {

		if(dao.login(item)==1)
			return true;

		return false;
	}

	@Override
	public List<Customer> list(Pager pager) {
		int total = dao.total(pager);

		pager.setTotal((float)total);
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
	public int checkId(String id) {

		return dao.checkId(id);
	}

}
