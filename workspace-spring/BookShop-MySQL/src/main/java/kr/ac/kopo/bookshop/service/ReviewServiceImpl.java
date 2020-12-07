package kr.ac.kopo.bookshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.bookshop.dao.ReviewDao;
import kr.ac.kopo.bookshop.model.Review;

@Service
public class ReviewServiceImpl implements ReviewService {
	
	@Autowired
	ReviewDao dao;
	
	@Override
	public List<Review> list(int bookid){
		return dao.list(bookid);
	}

	@Override
	public void add(Review item) {
		dao.add(item);
	}

	@Override
	public void delete(int reviewid, int custid) {
		dao.delete(reviewid,custid);
	}

	@Override
	public void update(Review item) {
		dao.update(item);
	}

	@Override
	public Review item(int reviewid) {
		return dao.item(reviewid);
	}

}
