package kr.ac.kopo.polycms.Dao;

import java.util.List;

import kr.ac.kopo.polycms.model.Article;
import kr.ac.kopo.polycms.model.Pager;

public interface ArticleDao {

	List<Article> list(Pager pager, int boardId);

	void add(Article item);

	Article item(int boardId, int articleId);

	void update(Article item);

	void delete(int boardId, int articleId);

	int total(int boardId, Pager pager);

}
