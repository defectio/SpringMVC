package spring_07_board.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import spring_07_board.dto.BoardDTO;
import spring_07_board.dto.PageDTO;

public class BoardDaoImp implements BoardDao {

	private SqlSessionTemplate sqlSession;
	
	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	/**
	 * 글 전체 목록을 출력한다.
	 */
	@Override
	public List<BoardDTO> selectBoardListMethod(PageDTO pdto) {
		return sqlSession.selectList("board.boardList", pdto);
	}
	
	/**
	 * 글을 작성한다.
	 */
	@Override
	public void boardWriteInsertMethod(BoardDTO board) {
		sqlSession.insert("board.boardInsert", board);
	}
	
	/**
	 * 게시글을 조회한다.
	 */
	@Override
	public BoardDTO selectBoardByNumMethod(int num) {
		return sqlSession.selectOne("board.boardByNum", num);
	}
	
	/**
	 * 게시글의 조회수를 증가한다.
	 */
	@Override
	public void readCountMethod(int num) {
		sqlSession.update("board.readCount", num);
	}
	
	/**
	 * 게시글을 수정한다.
	 */
	@Override
	public void boardUpdateMethod(BoardDTO board) {
		sqlSession.update("board.updateByNum", board);
	}
	
	/**
	 * 게시글을 삭제한다.
	 */
	@Override
	public void boardDeleteMethod(int num) {
		sqlSession.delete("board.deleteByNum", num);
	}
	
	/**
	 * restep을 증가시킨다.
	 */
	@Override
	public void reStepUpdateMethod(BoardDTO board) {
		sqlSession.update("board.reStepUpdate", board);
	}

	@Override
	public int getTotalCount() {
		return sqlSession.selectOne("board.count");
	}
	
}