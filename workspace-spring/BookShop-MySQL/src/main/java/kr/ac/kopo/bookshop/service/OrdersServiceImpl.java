package kr.ac.kopo.bookshop.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.ac.kopo.bookshop.dao.DetailDao;
import kr.ac.kopo.bookshop.dao.OrdersDao;
import kr.ac.kopo.bookshop.model.Book;
import kr.ac.kopo.bookshop.model.Customer;
import kr.ac.kopo.bookshop.model.Detail;
import kr.ac.kopo.bookshop.model.Orders;
import kr.ac.kopo.bookshop.util.Pager;

@Service
public class OrdersServiceImpl implements OrdersService {
	
	@Autowired
	OrdersDao dao;	
	
	@Autowired
	DetailDao daoDetail;

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

	@Override
	@Transactional
	public void order(Customer customer, Map<Integer, Book> cart) {
		Orders item = new Orders();
		
		int saleprice = 0;
		for(Integer bookid : cart.keySet()) {
			Book book = cart.get(bookid);
			
			saleprice += book.getPrice() * book.getAmount();
		}
		
		item.setCustid(customer.getCustid());
		item.setSaleprice(saleprice);
		
		dao.add(item);
		
		for(Integer bookid : cart.keySet()) {
			Book book = cart.get(bookid);
			
			Detail detail = new Detail();
			
			detail.setOrderid( item.getOrderid() );
			detail.setBookid( book.getBookid() );
			detail.setAmount( book.getAmount() );
			
			daoDetail.add(detail);
		}
		
	}

}
