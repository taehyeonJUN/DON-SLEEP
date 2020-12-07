package kr.ac.kopo.polycms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.polycms.dao.BoardDao;
import kr.ac.kopo.polycms.model.BoardMaster;
@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	BoardDao dao;

	@Override
	public List<BoardMaster> list() {
		return dao.list() ;
	}

	@Override
	public void add(BoardMaster item) {
		dao.add(item);
		
		dao.createBoard(item.getBoardId());
		
		dao.createSeq(item.getBoardId());
		
		dao.createReply(item.getBoardId());
		
		dao.createReplySeq(item.getBoardId());
	}

	@Override
	public BoardMaster item(int board_id) {
		return dao.item(board_id);
	}

	@Override
	public void update(BoardMaster item) {
		dao.update(item);

	}

	@Override
	public void delete(int board_id) {
		dao.delete(board_id);
		
		dao.removeBoard(board_id);
		dao.removeSeq(board_id);
		dao.removeReply(board_id);
		dao.removeReplySeq(board_id);
	}

}
