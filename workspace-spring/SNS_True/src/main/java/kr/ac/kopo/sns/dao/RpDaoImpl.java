package kr.ac.kopo.sns.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.sns.model.Post;
import kr.ac.kopo.sns.model.Rp;
@Repository
public class RpDaoImpl implements RpDao {

	@Autowired
	SqlSession sql;
	
	@Override
	public int add(Rp rp) {
		return sql.insert("Rp.add",rp);
	}

	//선택한 게시글 조회
	@Override
	public Post item(int postNo) {
		return sql.selectOne("Rp.item", postNo);
	}

	// 선택한 게시글의 댓글 조회
	@Override
	public List<Rp> selectList(Rp rpPostNo) {
		return sql.selectList("Rp.list", rpPostNo);
	}

	@Override
	public int delete(int rpNo) {
		return sql.delete("Rp.delete", rpNo);
	}

	@Override
	public void update(int rpNo) {
		sql.update("Rp.Rpupdate", rpNo);
	}

}
