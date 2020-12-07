package kr.ac.kopo.bookshop.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.bookshop.model.Customer;
import kr.ac.kopo.bookshop.util.Pager;

@Repository
public class CustomerDaoImpl implements CustomerDao {
	
	@Autowired
	SqlSession sql;

	@Override
	public int total(Pager pager) {
		return sql.selectOne("customer.total", pager);
	}

	@Override
	public List<Customer> list(Pager pager) {
		return sql.selectList("customer.list", pager);
	}

	@Override
	public void add(Customer item) {
		sql.insert("customer.add", item);
	}

	@Override
	public Customer item(int custid) {
		return sql.selectOne("customer.item", custid);
	}

	@Override
	public void update(Customer item) {
		sql.update("customer.update", item);
	}

	@Override
	public void delete(int custid) {
		sql.delete("customer.delete", custid);
	}

	@Override
	public Customer login(Customer item) {		
		return sql.selectOne("customer.login", item);
	}

	@Override
	public int checkId(String id) {		
		return sql.selectOne("customer.checkid", id);
	}

}
