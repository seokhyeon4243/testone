package test.framework.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {
	
	// http://localhost:8080/spring/member/main
	@RequestMapping("/member/main")
	public String main() {
		return "/member/main";
	}
}
