package spring_07_board.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import spring_07_board.dto.BoardDTO;

public class BoardDaoImp implements BoardDao {

	private SqlSessionTemplate sqlSession;
	
	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	/**
	 * 글 전체 목록을 출력한다.
	 */
	@Override
	public List<BoardDTO> selectBoardListMethod() {
		return sqlSession.selectList("basic.boardList");
	}
	
	/**
	 * 글을 작성한다.
	 */
	@Override
	public void boardWriteInsertMethod(BoardDTO board) {
		sqlSession.insert("basic.boardInsert", board);
	}
	
	/**
	 * 게시글을 조회한다.
	 */
	@Override
	public BoardDTO selectBoardByNumMethod(int num) {
		return sqlSession.selectOne("basic.boardByNum", num);
	}
	
	/**
	 * 게시글의 조회수를 증가한다.
	 */
	@Override
	public void readCountMethod(int num) {
		sqlSession.update("basic.readCount", num);
	}
	
	/**
	 * 게시글을 수정한다.
	 */
	@Override
	public void boardUpdateMethod(BoardDTO board) {
		sqlSession.update("basic.updateByNum", board);
	}
	
	/**
	 * 게시글을 삭제한다.
	 */
	@Override
	public void boardDeleteMethod(int num) {
		sqlSession.delete("basic.deleteByNum", num);
	}
	
	/**
	 * restep을 증가시킨다.
	 */
	@Override
	public void reStepUpdateMethod(BoardDTO board) {
		sqlSession.update("basic.reStepUpdate", board);
	}
	
}