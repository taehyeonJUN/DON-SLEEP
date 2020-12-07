package hi.pizza.world.board;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import hi.pizza.world.comm.SearchInfo;

@Service("boardService")
public class BoardServiceImpl implements BoardService
{

	@Resource
	private BoardDao boardDao;
	
	//글 목록
		@Override
		public List<BoardVo> selectBoardList(SearchInfo searchInfo) {
			return boardDao.selectBoardList(searchInfo);
		}

	//글 내용
	@Override
	public BoardVo selectBoard(int bbsId) 
	{
		return boardDao.selectBoard(bbsId);
	}

	
	// 글 추가
	@Override
	public int insertBoard(BoardVo vo) 
	{
		int num = boardDao.insertBoard(vo);
		return num;
	}

	// 글 수정
	@Override
	public int updateBoard(BoardVo vo) 
	{
		return boardDao.updateBoard(vo);
	}

	// 글 삭제
	@Override
	public int deleteBoard(int bbsId) 
	{
		return boardDao.deleteBoard(bbsId);
	}
	
	@Override
	public int selectCount(SearchInfo searchInfo) 
	{
		return boardDao.selectCount(searchInfo);
	}


}
