package spring_06_mvc.sec05_redirect;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * http://localhost:8081/${contextPath}/memList.htm
 * @author USER
 */
@Controller
public class MemListController {

	private MemDAO dao;
	
	public MemListController() {}
	
    public void setDao(MemDAO dao) {
		this.dao = dao;
	}
    
    /**
     * member 목록을 리턴한다.
     * @param mav
     * @return
     */
    @RequestMapping("/memList.htm")
    public ModelAndView list(ModelAndView mav) {
    	mav.addObject("aList", dao.list());
    	mav.setViewName("view/sec05/memList");
    	
    	return mav;
    }
}
