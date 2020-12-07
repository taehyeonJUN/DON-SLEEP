package kr.ac.kopo.sns.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.sns.model.Photo;

@Repository
public class PhotoDaoImpl implements PhotoDao {

	@Autowired
	SqlSession sql;
	
	
	@Override
	public void addPhoto(Photo phoVo) {
		sql.insert("photo.addPhoto", phoVo);

	}


	@Override
	public List<Photo> photoList(int postNo) {
		
		return sql.selectList("photo.selectPhoto", postNo);
	}
	
	

}
