package spring_07_board.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import spring_07_board.dto.BoardDTO;
import spring_07_board.dto.PageDTO;
import spring_07_board.service.BoardService;

@Controller
public class BoardController {

	private BoardService service;
	private int currentPage;
	private PageDTO pdto;
	
	public void setService(BoardService service) {
		this.service = service;
	}

	/**
	 * main.do 호출 시 목록페이지를 리턴한다.
	 * @param mav
	 * @return
	 */
	@GetMapping("/main.do")
	public ModelAndView boardList(ModelAndView mav, PageDTO pv) {
		
		int totalRecord = service.boardTotalCount();
		
		if (totalRecord >= 1) { //현재 DB에 저장된 레코드가 있으면 실행됨.
			if(pv.getCurrentPage() == 0) {  //처음 게시판메뉴를 클릭하고 들어왔을때(currentPage 값을 안넘겨줌)
				currentPage = 1;
			} else {
				currentPage = pv.getCurrentPage();
			}
			
			/* currentPage, totalRecord가 저장된 PageDTO 객체를 넘겨야함. */
			pdto = new PageDTO(currentPage, totalRecord);   //검색어 처리 전
			//currentPage, totalRecord값으로 PageDTO 생성하면, 
			//startRow, endRow, totalPage, startPage, endPage, number가 PageDTO에 저장됨
			
			mav.addObject("board", service.selectBoardList(pdto));
			mav.addObject("pv", pdto);
		} 
		mav.setViewName("boardList");

		return mav;
	}

	/**
	 * 글 작성 페이지를 리턴한다.
	 * @param board
	 * @return
	 */
	@GetMapping(value = "/write.do")
	public String boardWritePage(@ModelAttribute("board") BoardDTO board) {
		return "boardWrite";
	}

	/**
	 * 게시글을 작성한다.(제목글, 답변글 모두 같은 액션으로 동작함)
	 * @param mav
	 * @param board
	 * @return
	 */
	@PostMapping(value = "/write.do")
	public ModelAndView boardWriteMethod(ModelAndView mav, @ModelAttribute("board") BoardDTO board) {
		/**
		 * 제목글 저장 시 num, ref, re_step, re_level는 모두 default값으로 전달되기 때문에 0으로 넘어온다.
		 * 답변글 저장 시 num, ref, re_step, re_level 값이 넘어 오는데, ref(제목글과 동일한값)는 무조건 0이 아닌 값이 넘어온다.
		 */
		if (board.getRef() != 0) { // 답변글
			 service.boardReplyWriteInsert(board);
		} else { // 제목글
			service.boardWriteInsert(board);
		}		
		// 게시글 저장 후 list페이지로 redirect
		mav.setViewName("redirect:/main.do");
		
		return mav;
	}

	/**
	 * 게시글을 조회한다.
	 * @param num
	 * @param mav
	 * @return
	 */
	@GetMapping("/view.do")
	public ModelAndView boardDetailViewMethod(int num, ModelAndView mav) {
		BoardDTO board = service.selectBoardByNum(num, true);
		mav.addObject("board", board);
		mav.setViewName("boardView");
		
		return mav;
	}

	/**
	 * 게시글 수정페이지를 리턴한다.
	 * @param num
	 * @param mav
	 * @return
	 */
	@GetMapping(value = "/update.do")
	public ModelAndView updateBoardPage(int num, ModelAndView mav) {
		BoardDTO board = service.selectBoardByNum(num, false);
		mav.addObject("board", board);
		mav.setViewName("boardUpdate");
		
		return mav;
	}
	
	/**
	 * 게시글을 수정한다.
	 * @param board
	 * @return
	 */
	@PostMapping(value = "/update.do")
	public String updateBoardSubConMethod(BoardDTO board) {
		service.boardUpdate(board);
		
		return "redirect:/view.do?num="+board.getNum();
	}
	
	/**
	 * 게시글을 삭제한다.
	 * @param num
	 * @return
	 */
	@GetMapping("/delete.do")
	public String deleteBoardMethod(int num) {
		service.boardDelete(num);
		
		return "redirect:/main.do";
	}
	
}