package kr.ac.kopo.polycms.Dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.polycms.model.boardmaster;

@Repository
public class BoardDaoImpl implements BoardDao {

	@Autowired
	SqlSession sql;
	
	@Override
	public List<boardmaster> list() {
		return sql.selectList("boardmaster.list");
	}

	@Override
	public void add(boardmaster item) {
		sql.insert("boardmaster.add",item);
	}

	@Override
	public boardmaster item(int board_id) {
		return sql.selectOne("boardmaster.item", board_id);
	}

	@Override
	public void update(boardmaster item) {
		sql.update("boardmaster.update", item);
	}

	@Override
	public void delete(int board_id) {
		sql.delete("boardmaster.delete", board_id);
	}

	@Override
	public void creatBoard(int boardId) {
		sql.update("boardmaster.create_board",boardId);
	}

	@Override
	public void removeBoard(int board_id) {
		sql.update("boardmaster.remove_board",board_id);
	}
	
	@Override
	public void createSeq(int boardId) {
		sql.update("board_master.create_seq", boardId);
		
	}

	@Override
	public void createReply(int boardId) {
		sql.update("board_master.create_reply", boardId);
		
	}

}
