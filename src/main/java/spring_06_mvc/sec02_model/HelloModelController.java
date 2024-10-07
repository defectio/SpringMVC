package spring_06_mvc.sec02_model;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 요청URL : http://localhost:${port}/${contextPath}/view/sec02/helloModel.htm
 *  - 뷰에 대한 정보가 없음
 *  - 요청 url에 사용된 정보(/view/sec02/helloModel)를 이용해서 jsp 파일을 찾음
 * @author USER
 *
 */
@Controller
public class HelloModelController {
	
	// 잘 사용하는 방식은 아님. 한번 짚고만 넘어가(이렇게 하는 경우 거의 없음)
	@RequestMapping("/view/spring_06_mvc/sec02/helloModel.htm")
	public Model search() {
		Model model = new ExtendedModelMap();
		model.addAttribute("id", "korea"); // key-value

		return model;
	}
	
}