package spring_07_board.service;

import java.util.List;

import spring_07_board.dto.BoardDTO;
import spring_07_board.dto.PageDTO;

public interface BoardService {

	/**
	 * 게시글 전체 목록을 가져온다.
	 * @return
	 */
	public List<BoardDTO> selectBoardList(PageDTO pdto);

	/**
	 * 게시글을 작성한다.
	 * @param board
	 */
	public void boardWriteInsert(BoardDTO board);
	
	/**
	 * 게시글을 조회한다.
	 */
	public BoardDTO selectBoardByNum(int num, boolean isCountUp);
	
	/*
	 * 게시글을 수정한다.
	 */
	public void boardUpdate(BoardDTO board);
	
	/**
	 * 게시글을 삭제한다.
	 * @param num
	 */
	public void boardDelete(int num);
	
	/**
	 * 답변글을 작성한다.
	 */
	public void boardReplyWriteInsert(BoardDTO board);
	
	/**
	 * 총 게시글 수를 리턴한다.
	 * @return
	 */
	public int boardTotalCount();
}