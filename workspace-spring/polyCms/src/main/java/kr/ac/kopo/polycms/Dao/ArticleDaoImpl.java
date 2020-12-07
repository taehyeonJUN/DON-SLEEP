package kr.ac.kopo.polycms.Dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.polycms.model.Article;
import kr.ac.kopo.polycms.model.Pager;

@Repository
public class ArticleDaoImpl implements ArticleDao{
	
	
	@Autowired
	SqlSession sql;
	
	@Override
	public int total(int boardId, Pager pager) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("boardId", boardId);
		map.put("pager", pager);
		return sql.selectOne("article.total", map);
	}
		
	@Override
	public List<Article> list(Pager pager,int boardId) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("boardId", boardId);
		map.put("pager", pager);
		return sql.selectList("article.list", map);
	}

	@Override
	public void add(Article item) {
		sql.insert("article.add", item);
	}

	@Override
	public Article item(int boardId, int articleId) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("boardId", boardId);
		map.put("articleId", articleId);
		
		return sql.selectOne("article.item", map);
	}

	@Override
	public void update(Article item) {
		 sql.update("article.update", item);
	}

	@Override
	public void delete(int boardId, int articleId) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("boardId", boardId);
		map.put("articleId", articleId);
		sql.delete("article.delete", map);
	}



	
}
