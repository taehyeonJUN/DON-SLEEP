package kr.ac.kopo.polycms.service;

import java.util.List;

import kr.ac.kopo.polycms.model.Article;
import kr.ac.kopo.polycms.utill.Pager;

public interface ArticleService {

	List<Article> list(int boardId, Pager pager);

	void add(Article item);

	Article item(int boardId, int articleId);

	void update(Article item);

	void delete(int boardId, int articleId);

	void dummy(int boardId);

	

}
