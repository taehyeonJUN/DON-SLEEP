package kr.ac.kopo.polycms.Service;

import java.util.List;

import kr.ac.kopo.polycms.model.boardmaster;

public interface BoardService {

	List<boardmaster> list();

	void add(boardmaster item);

	boardmaster item(int board_id);

	void update(boardmaster item);

	void delete(int board_id);

}
