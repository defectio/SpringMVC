package spring_07_board.dao;

import java.util.List;

import spring_07_board.dto.BoardDTO;
import spring_07_board.dto.PageDTO;

public interface BoardDao {

	/**
	 * 글 전체 목록을 출력한다.
	 * @return
	 */
	public List<BoardDTO> selectBoardListMethod(PageDTO pdto);
	
	/**
	 * 글을 작성한다.
	 * @param board
	 */
	public void boardWriteInsertMethod(BoardDTO board);
	
	/**
	 * 게시글을 조회한다.
	 * @param num
	 * @return
	 */
	public BoardDTO selectBoardByNumMethod(int num);
	
	/**
	 * 게시글의 조회수를 증가한다.
	 * @param num
	 */
	public void readCountMethod(int num);
	
	/**
	 * 게시글을 수정한다.
	 * @param board
	 */
	public void boardUpdateMethod(BoardDTO board);
	
	/**
	 * 게시글을 삭제한다.
	 * @param num
	 */
	public void boardDeleteMethod(int num);
	
	/**
	 * restep을 증가시킨다.
	 * @param board
	 */
	public void reStepUpdateMethod(BoardDTO board);
	
	/**
	 * 게시글의 총 건수를 리턴한다.
	 * @return
	 */
	public int getTotalCount();
	
}