package hi.pizza.world.board;

import java.util.List;

import hi.pizza.world.comm.SearchInfo;

public interface BoardService {
	
	List<BoardVo> selectBoardList(SearchInfo searchInfo);

	int insertBoard(BoardVo vo);

	BoardVo selectBoard(int bbsId);

	int updateBoard(BoardVo vo);

	int deleteBoard(int bbsId);
	
	int selectCount(SearchInfo searchInfo);

}