package kr.ac.kopo.bookshop.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.bookshop.model.Orders;
import kr.ac.kopo.bookshop.util.Pager;

@Repository
public class OrdersDaoImpl implements OrdersDao {
	
	@Autowired
	SqlSession sql;

	@Override
	public int total(Pager pager) {
		return sql.selectOne("orders.total", pager);
	}

	@Override
	public List<Orders> list(Pager pager) {
		return sql.selectList("orders.list", pager);
	}

	@Override
	public void add(Orders item) {
		sql.insert("orders.add", item);
	}

	@Override
	public Orders item(int orderid) {
		return sql.selectOne("orders.item", orderid);
	}

	@Override
	public void update(Orders item) {
		sql.update("orders.update", item);
	}

	@Override
	public void delete(int orderid) {
		sql.delete("orders.delete", orderid);
	}

}
