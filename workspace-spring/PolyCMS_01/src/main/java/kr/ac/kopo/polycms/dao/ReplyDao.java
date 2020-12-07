package kr.ac.kopo.polycms.dao;

import java.util.List;

import kr.ac.kopo.polycms.model.Reply;

public interface ReplyDao {

	List<Reply> list(int boardId, int articleId);

	void add(int boardId, int articleId, Reply item);

}
