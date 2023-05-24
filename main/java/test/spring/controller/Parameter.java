package test.spring.controller;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import test.spring.component.ParameterDTO;

@Controller
public class Parameter {
	
	@Autowired	// 의존성 주입(DI)
	private Date day;
	
	@RequestMapping("/param/form")
	public String  form() {
		System.out.println(day);
		return "/0519/form";
	}
	@RequestMapping("/param/pro")
	public String pro(ParameterDTO dto , Model model) {
	// public String pro(HttpServletRequest request , Model model) {
	//public String pro(Model model , String id , String pw , int age) {
	/*	
		List<Integer> list = new ArrayList();
		list.add(100);
		list.add(200);
		list.add(300);
		list.add(400);
		
		model.addAttribute("list",list);
		
		model.addAttribute("id",id);
		model.addAttribute("pw",pw);
		model.addAttribute("age",age);
		model.addAttribute("number",400);
	*/
		return "/0519/pro";
	}
	// parameter , HttpServletRequest , HttpServletResponse
	// HttpSession , ServletConfig(web.xml 설정된 정보 제공)
	// ApplicationContext
	// 주료 사용하는 4가지 (parameter , HttpServlet , HttpServletResponse , HttpSession)
}
