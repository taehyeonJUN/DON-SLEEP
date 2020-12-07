package kr.ac.kopo.polycms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.polycms.dao.ReplyDao;
import kr.ac.kopo.polycms.model.Reply;

@Service
public class ReplyServiceImpl implements ReplyService {

	@Autowired
	ReplyDao dao;
	
	@Override
	public List<Reply> list(int boardId, int articleId) {
		return dao.list(boardId,articleId);
	}

	@Override
	public void add(int boardId, int articleId, Reply item) {
		dao.add(boardId,articleId,item);
	}

}
