package kr.ac.kopo.polycms.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.polycms.Dao.ArticleDao;
import kr.ac.kopo.polycms.model.Article;
import kr.ac.kopo.polycms.model.Pager;

@Service
public class ArticleServiceImple implements ArticleService{
	
	@Autowired
	ArticleDao dao;
	
	@Override
	public List<Article> list(int boardId,Pager pager) {
		int total = dao.total(boardId,pager);
		
		pager.setTotal(total);
		
		return dao.list(pager,boardId);
	}

	@Override
	public void add(Article item) {
		dao.add(item);
		
	}

	@Override
	public Article item(int boardId, int articleId) {
		return dao.item(boardId,articleId);
	}

	@Override
	public void update(Article item) {
		dao.update(item);
		
	}

	@Override
	public void delete(int boardId, int articleId) {
		dao.delete(boardId,articleId);
		
	}

	@Override
	public void dummy(int boardId) {
		for (int index = 0; index < 100; index++) {
			Article item = new Article();
			item.setBoardId(boardId);
			item.setSubject("제목"+boardId+"_"+index);
			item.setContent("내용입니다"+boardId+"_"+index);
			dao.add(item);
		}
		
	}

}
