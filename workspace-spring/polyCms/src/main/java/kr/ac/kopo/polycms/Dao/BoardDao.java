package kr.ac.kopo.polycms.Dao;

import java.util.List;

import kr.ac.kopo.polycms.model.boardmaster;

public interface BoardDao {

	List<boardmaster> list();

	void add(boardmaster item);

	boardmaster item(int board_id);

	void update(boardmaster item);

	void delete(int board_id);

	void creatBoard(int board_id);

	void removeBoard(int board_id);

	void createSeq(int boardId);

	void createReply(int boardId);
	

}
