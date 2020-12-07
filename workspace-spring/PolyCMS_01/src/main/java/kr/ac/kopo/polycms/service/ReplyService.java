package kr.ac.kopo.polycms.service;

import java.util.List;

import kr.ac.kopo.polycms.model.Reply;

public interface ReplyService {

	List<Reply> list(int boardId, int articleId);

	void add(int boardId, int articleId, Reply item);

}
