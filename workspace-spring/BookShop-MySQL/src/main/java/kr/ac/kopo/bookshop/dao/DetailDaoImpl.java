package kr.ac.kopo.bookshop.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.bookshop.model.Detail;

@Repository
public class DetailDaoImpl implements DetailDao {
	
	@Autowired
	SqlSession sql;

	@Override
	public void add(Detail detail) {
		sql.insert("detail.add", detail);
	}

}
