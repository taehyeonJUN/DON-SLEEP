package kr.ac.kopo.bookshop.service;

import java.util.List;

import kr.ac.kopo.bookshop.model.Review;

public interface ReviewService {

	List<Review> list(int bookid);

	void add(Review item);

	

	void delete(int reviewid, int custid);

	void update(Review item);

	Review item(int reviewid);

}
