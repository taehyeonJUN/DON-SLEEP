package hi.pizza.world.board;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import hi.pizza.world.comm.SearchInfo;

@Mapper
public interface BoardDao {
	
	List<BoardVo> selectBoardList(SearchInfo searchInfo);

	int insertBoard(BoardVo vo);

	BoardVo selectBoard(int bbsId);

	int updateBoard(BoardVo vo);

	int deleteBoard(int bbsId);

	int selectCount(SearchInfo searchInfo);

}