package spring_06_mvc.sec03_modelandview;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 요청URL : http://localhost:${port}/${contextPath}/helloModelView.htm
 * @author USER
 */
@Controller
public class HelloModelAndViewController {

	@RequestMapping("/helloModelView.htm")
	public ModelAndView search() {
		ModelAndView mav = new ModelAndView();
		
		//뷰페이지에서 사용할 "데이터" 저장
		mav.addObject("name", "kim");
		mav.addObject("age", 30);
		
		//"뷰페이지"에 대한 정보를 넘겨줌
		mav.setViewName("view/sec03/helloModelView");
		
		return mav;
	}

}