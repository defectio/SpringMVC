package spring_06_mvc.sec06_resultmap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * http://localhost:8081/${contextPath}/orderInsert.htm
 * @author USER
 */
@Controller
public class OrderInsertController {
	
	private OrderDAO dao;
	
	public OrderInsertController() {}
	
	public void setDao(OrderDAO dao) {
		this.dao = dao;
	}

	/**
	 * 주문등록 페이지 리턴
	 * @return
	 */
	@RequestMapping(value="/orderInsert.htm", method=RequestMethod.GET)
	public String form() {
		return "view/spring_06_mvc/sec06/form";
	}
	
	/**
	 * 주문등록
	 * @param dto
	 * @return
	 */
	@RequestMapping(value="/orderInsert.htm", method=RequestMethod.POST)
	public String submit(OrderDTO dto) {
		//System.out.println("dto의 주소값 : "+dto.getList());
		//System.out.println("form.jsp에서 넘어온 List의 크기 : "+dto.getList().size());
//		for(int i = 0; i < dto.getList().size(); i++) {
//			System.out.println("id : "+dto.getList().get(i).getId());
//			System.out.println("cnt : "+dto.getList().get(i).getCnt());
//			System.out.println("remark : "+dto.getList().get(i).getRemark());
//			System.out.println("address : "+dto.getAddress());
//		}
		
		dao.insertMethod(dto);
		return "redirect:/orderList.htm";  //클라이언트가 컨트롤러 호출할 수 있도록 redirect 해야함
	}

}