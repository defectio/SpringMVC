package spring_07_board.service;

import java.util.List;

import spring_07_board.dao.BoardDao;
import spring_07_board.dto.BoardDTO;
import spring_07_board.dto.PageDTO;

public class BoardServiceImp implements BoardService {

	private BoardDao dao;
	
	public void setDao(BoardDao dao) {
		this.dao = dao;
	}
	
	/**
	 * 게시글 전체 목록을 가져온다.
	 */
	@Override
	public List<BoardDTO> selectBoardList(PageDTO pdto) {
		return dao.selectBoardListMethod(pdto);
	}
	
	/**
	 * 게시글을 작성한다.
	 */
	@Override
	public void boardWriteInsert(BoardDTO board) {
		dao.boardWriteInsertMethod(board);
	}
	
	/**
	 * 게시글을 조회한다.
	 */
	@Override
	public BoardDTO selectBoardByNum(int num, boolean isCountUp) {
		if (isCountUp) {
			dao.readCountMethod(num);  // 조회수 증가
		}
		return dao.selectBoardByNumMethod(num);
	}
	
	/**
	 * 게시글을 수정한다.
	 */
	@Override
	public void boardUpdate(BoardDTO board) {
		dao.boardUpdateMethod(board);
	}
	
	/**
	 * 게시글을 삭제한다.
	 */
	@Override
	public void boardDelete(int num) {
		dao.boardDeleteMethod(num);
	}
	
	/**
	 * 답변글을 작성한다.
	 */
	@Override
	public void boardReplyWriteInsert(BoardDTO board) {
		//지금 작성하려는 답변글을 제외한 모든 re_step 업데이트
		dao.reStepUpdateMethod(board);
		
		//지금 작성한 글의 re_step, re_level 1씩 증가
		board.setRe_step(board.getRe_step()+1);
		board.setRe_level(board.getRe_level()+1);
		
		//작성글 저장
		dao.boardWriteInsertMethod(board);
	}

	/**
	 * 총 게시글 수를 리턴하다.
	 */
	@Override
	public int boardTotalCount() {
		return dao.getTotalCount();
	}

}