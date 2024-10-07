package spring_06_mvc.sec05_redirect;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * http://localhost:8081/${contextPath}/memInsert.htm
 * @author USER
 */
@Controller
public class MemInsertController {

	private MemDAO dao;
	
	public MemInsertController() {}
	
	public void setDao(MemDAO dao) {
		this.dao = dao;
	}
	
	/**
	 * 회원 등록 페이지 리턴
	 * @return
	 */
	@RequestMapping(value="/memInsert.htm", method=RequestMethod.GET)
	public String form() {
		return "view/spring_06_mvc/sec05/memForm";
	}
	
	/**
	 * 회원등록 후 회원 목록 페이지 redirect
	 * @param dto
	 * @return
	 */
	@RequestMapping(value="/memInsert.htm", method=RequestMethod.POST)
	public String submit(MemDTO dto) {
		//System.out.println("이름 : "+dto.getName());
		//System.out.println("나이 : "+dto.getAge());
		//System.out.println("지역 : "+dto.getLoc());
		
		dao.insertMethod(dto);

		/**
		 * [redirect]
		 *  - 사용자가 처음 요청한 URL이 아닌, 다른 URL로 재요청하는 것을 의미함
		 *  - ex) 로그인 시도 시, 로그인 페이지에서 성공 또는 실패 페이지로 이동시킨다.
		 *  - "redirect:/" : redirect로 지정된 URL 요청을 다시함.
		 *  (1) 클라이언트에서 memList.htm 재요청
		 *  (2) dispatcher servlet(프론트컨트롤러) 이 memList.htm(요청)을 받아
		 *  (3) handlermapping 를 통해서 memList.htm(요청)을 가지고 있는 controller(빈이 등록되어야 함)를 찾는다.
		 *  (4) 해당하는 controller의 memList.htm 을 재요청 한다.
		 *  
		 *  cf) "view/sec05/memList"로 리턴 시 페이지만 호출됨. DB에서 데이터를 못 불러옴
		 */
		return "redirect:/memList.htm";	
	}
}
