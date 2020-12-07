package kr.ac.kopo.bookshop.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.bookshop.model.Review;

@Repository
public class ReviewDaoImpl implements ReviewDao {
	@Autowired
	SqlSession sql;
	
	@Override
	public List<Review> list(int bookid) {
		return sql.selectList("review.list",bookid);
	}

	@Override
	public void add(Review item) {
		sql.insert("review.add", item);
	}

	@Override
	public void delete(int reviewid, int custid) {
		 HashMap<String, Integer> map = new HashMap<String, Integer>();
		 
		 map.put("reviewid", reviewid);
		 map.put("custid", custid);
		
		 
		sql.delete("review.delete", map);
	}

	@Override
	public void update(Review item) {
		sql.update("review.update",item);
	}

	@Override
	public Review item(int reviewid) {
		return sql.selectOne("review.item", reviewid);
	}

}
