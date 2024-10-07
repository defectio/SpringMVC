package spring_06_mvc.sec06_resultmap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * http://localhost:8081/${contextPath}/orderList.htm
 * @author USER
 */
@Controller
public class OrderListController {
	private OrderDAO dao;
	
	public OrderListController() {
	
	}
	
	public void setDao(OrderDAO dao) {
		this.dao = dao;
	}
	
	/**
	 * 주문 목록을 리턴한다.
	 * @param mav
	 * @return
	 */
	@RequestMapping(value="/orderList.htm")
	public ModelAndView process(ModelAndView mav) {
		mav.addObject("aList", dao.selectMethod());		
		mav.setViewName("view/sec06/list");
		
		return mav;
	}
	
}