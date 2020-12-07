package kr.ac.kopo.polycms.service;

import java.util.List;

import kr.ac.kopo.polycms.model.BoardMaster;

public interface BoardService {

	List<BoardMaster> list();

	void add(BoardMaster item);

	BoardMaster item(int board_id);

	void update(BoardMaster item);

	void delete(int board_id);

}
