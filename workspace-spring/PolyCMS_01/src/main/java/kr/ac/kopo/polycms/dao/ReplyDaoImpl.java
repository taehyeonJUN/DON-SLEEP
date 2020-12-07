package kr.ac.kopo.polycms.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.polycms.model.Reply;

@Repository
public class ReplyDaoImpl implements ReplyDao {

	@Autowired
	SqlSession sql;
	
	@Override
	public List<Reply> list(int boardId, int articleId) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("boardId", boardId);
		map.put("articleId", articleId);
		
		return sql.selectList("reply.list", map);
	}

	@Override
	public void add(int boardId, int articleId, Reply item) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("boardId", boardId);
		map.put("articleId", articleId);
		map.put("reply", item);
		
		
		sql.insert("reply.add", map);
	}

}
