package spring_06_mvc.sec04_command;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * 요청URL : http://localhost:${port}/${contextPath}/mem.htm
 *  - DTO의 멤버변수와 jsp-form태그의 name 속성이 같을때 automapping
 * @author USER
 *
 */
@Controller
public class HelloCommandController {
	
	/**
	 * GET방식으로 /mem.htm 요청
	 *  - value값이 동일하더라도 method가 다르면 다른 방식으로 처리됨.
	 * @return
	 */
	@RequestMapping(value="/mem.htm", method=RequestMethod.GET)
	public String form() {
		// 뷰페이지만 응답하려고할 때 -> 리턴 타입을 스트링으로 하고, 뷰페이지 넘긴다.
		return "view/spring_06_mvc/sec04/memForm";
	}
	
	/**
	 * POST방식으로 /mem.htm 요청
	 *  - value값이 동일하더라도 method가 다르면 다른 방식으로 처리됨.
	 *  - [방법 1] basic : form에서 넘겨주는 name 속성값과 동일한 매개변수로 받는다.
	 * @param req
	 * @param mav
	 * @return
	 */
//	@RequestMapping(value="/mem.htm", method=RequestMethod.POST)
//  	public ModelAndView submit(String name, int age) {
//		System.out.println("name : " + name);
//		System.out.println("age : " + age);
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("name", name);
//		mav.addObject("age", age);
//		mav.setViewName("view/sec04/memPro");
//		
//		return mav;
//	}
	
	/**
	 *  POST방식으로 /mem.htm 요청
	 *  - value값이 동일하더라도 method가 다르면 다른 방식으로 처리됨.
	 *  - [방법 2] 서버로부터 받아올 값들이 많을 때 -> DTO 타입으로 받아온다.
	 *  - ex. 회원가입 시 받아와야할 회원정보들이 많을 때
	 *  - 매개변수 선언과 동시에 객체 생성
	 * @param dto
	 * @param mav
	 * @return
	 */
//	@RequestMapping(value="/mem.htm", method=RequestMethod.POST)
//	public ModelAndView submit(MemDTO dto, ModelAndView mav) {
//		System.out.println("name : " + dto.getName());
//		System.out.println("age : " + dto.getAge());
//		mav.addObject("dto", dto);
//		mav.setViewName("view/sec04/memPro");
//		return mav;
//	}
	
	/**
	 * POST방식으로 /mem.htm 요청
	 *  - [방법 3-1] ModelAttribute 어노테이션 사용
	 *  - form태그의 name속성값과 DTO 멤버변수명이 같아서 auto mapping됨. -> addObject() 필요 없음.
	 *  - memPro 페이지에서는 vo1(어노테이션)로 값에 접근해야함.
	 * @param dto
	 * @param mav
	 * @return
	 */
//	@RequestMapping(value="/mem.htm", method=RequestMethod.POST)
//	public ModelAndView submit(@ModelAttribute("vo1") MemDTO dto, ModelAndView mav) {
//		mav.setViewName("view/sec04/memPro");
//		
//		return mav;
//	}
	
	/**
	 * POST방식으로 /mem.htm 요청
	 *  - [방법 3-2] ModelAttribute 어노테이션 사용
	 *  - form태그의 name속성값과 DTO 멤버변수명이 같아서 auto mapping됨. -> addObject() 필요 없음.
	 *  - 뷰페이지에 대한 정보만 반환하면됨. -> 리턴타입을 String으로 바꿔서 페이지 경로만 넘기면 된다.
	 * @param dto
	 * @return
	 */
//	@RequestMapping(value="/mem.htm", method=RequestMethod.POST)
//	public String submit(@ModelAttribute("vo2") MemDTO dto) { 		
//		return "view/sec04/memPro";
//	}
	
	/**
	 * POST방식으로 /mem.htm 요청
	 *  - [방법 4] HttpServletRequest 객체 이용
	 *  - HttpServletRequest객체의 parameter를 이용해서 데이터 전달받음
	 * @param req
	 * @param mav
	 * @return
	 */
	@RequestMapping(value="/mem.htm", method=RequestMethod.POST)
	public ModelAndView submit(HttpServletRequest req, ModelAndView mav) {
		mav.addObject("req_name", req.getParameter("name"));
		mav.addObject("req_age", req.getParameter("age"));
		mav.addObject("req_address", req.getRemoteAddr()); // req의 ip 주소(클라이언트의 ip주소)
		mav.setViewName("view/spring_06_mvc/sec04/memPro");
		
		return mav;
	}
	
	/**
	 * [참고] HashMap으로 받는건 안됨.
	 * @param map
	 * @return
	 */
//	@RequestMapping(value="/mem.htm", method=RequestMethod.POST)
//	public String submit(@ModelAttribute("hp") HashMap<String, Object> map) {
//		System.out.println(map.get("name"));
//		System.out.println(map.get("age"));
//		
//		return "view/sec04/memPro";
//	}
	
}