package kr.ac.kopo.polycms.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.polycms.Dao.BoardDao;
import kr.ac.kopo.polycms.model.boardmaster;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	BoardDao dao;
	
	@Override
	public List<boardmaster> list() {
		return dao.list();
	}

	@Override
	public void add(boardmaster item) {
		dao.add(item);
		dao.creatBoard(item.getBoardId());
		dao.createSeq(item.getBoardId());
		dao.createReply(item.getBoardId());
	}

	@Override
	public boardmaster item(int board_id) {
		return dao.item(board_id);
	}

	@Override
	public void update(boardmaster item) {
		dao.update(item);
	}

	@Override
	public void delete(int board_id) {
		dao.delete(board_id);
		dao.removeBoard(board_id);
	}

}
