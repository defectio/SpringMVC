package spring_06_mvc.sec01_basic;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 서블릿(bean 설정파일)에 controller로 등록한다.
 *  - 요청URL : http://localhost:${port}/${contextPath}/hello.htm
 * @author USER
 *
 */
@Controller
public class HelloController {
	
	/**
	 * http://localhost:${port}/${contextPath}/hello.htm 이 요청되었을때 search 메소드를 실행하고 뷰에 대한 정보("view/part01/hello")를 리턴
	 * @return
	 */
	@RequestMapping("/hello.htm")
	public String search() {
		int sum = 0;
		for (int i = 0; i < 5; i++) {
			sum = sum + i;
			System.out.printf("i=%d sum=%d\n", i , sum);
		}
		return "view/sec01/hello";
	}

}
