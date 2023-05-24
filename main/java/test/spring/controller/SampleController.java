package test.spring.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import test.spring.component.SampleDTO;
import test.spring.service.SampleService;

@Controller
@RequestMapping("/sample/*")	// URL 설정
public class SampleController {
	
	@Autowired	// 의존성 주입
	private SampleService service;
	
	@RequestMapping("list")	// URL 설정
	public String sample(Model model) {
		List<SampleDTO> list = service.all();
		System.out.println(list);
		
		model.addAttribute("list" , list);
		return "/sample/list";
	}
	
	@RequestMapping("idList")	// URL 설정
	public String idList(Model model) {
		model.addAttribute("idList" , service.idList());
		return "/sample/idList";
	}
	
	@RequestMapping("search")
	public String search() {
		return "/sample/search";
	}
	
	@RequestMapping("pwFind")
	public String pwFind(String id , Model model) {
		model.addAttribute("pw" , service.pwFind(id));
		return "/sample/search";
	}
	
	@RequestMapping("login")
	public String login(String id , String pw , Model model) {
		model.addAttribute("result" , service.loginCheck(id, pw));
		return "/sample/search";
	}
	
	@RequestMapping("insert")
	public String insert(SampleDTO dto , Model model) {
		service.insert(dto);
		return "/sample/search";
	}
	
	
	
	// http://localhost8080/spring/sample/
	// @GetMapping() 
	// @PostMapping() -- 로그인 / 노출되면 안되는 파라미터가 들어가는 경우 / 파일업로드
	// @RequestMapping(value="/sample/*" , method={RequestMethod.GET , RequestMethod.POST})
	@RequestMapping("ex01")
	public void basic() {
		System.out.println("basic()");
	}
	
	// http://localhost:8080/spring/sample/ex02?name=java&age=20
	@RequestMapping("ex02")
	public String ex02(String name , int age) {
		System.out.println(name);
		System.out.println(age);
		return "/0522/ex02";
	}
	
	// http://localhost:8080/spring/sample/ex03?nnnn=korea&aaa=50
		@RequestMapping("ex03")
		public String ex03(@RequestParam(value="nnnn" , required=false , defaultValue="java") String name ,
							@RequestParam("aaa") int age) {
			System.out.println(name);
			System.out.println(age);
			return "/0522/ex03";
		}
		
		// http://localhost:8080/spring/sample/ex04?ch=aaa&ch=bbb&ch=ccc
		@RequestMapping("ex04")
		public String ex04(String [] ch) {
			System.out.println(ch[0]);
			System.out.println(ch[1]);
			System.out.println(ch[2]);
			return "/0522/ex04";
		}
		
		// http://localhost:8080/spring/sample/ex05?ch=aaa&ch=bbb&ch=ccc
		@RequestMapping("ex05")
		public String ex05(@RequestParam("ch") ArrayList<String> ch) {
			System.out.println(ch.get(0));
			System.out.println(ch.get(1));
			System.out.println(ch.get(2));
			return "/0522/ex05";
		}
		
		// http://localhost:8080/spring/sample/ex06?name=aaa&age=20&day=2023/05/20
		@RequestMapping("ex06")
		public String ex06(SampleDTO dto) {
			System.out.println(dto.getName());
			System.out.println(dto.getAge());
			System.out.println(dto.getDay());
			return "/0522/ex06";
		}
		
		@RequestMapping("ex07")
		public String ex07(SampleDTO dto ,
							@ModelAttribute("name") String name ,
							@ModelAttribute("age") int age ,
							Model model) {
			
			model.addAttribute("num" , 777);	// view로 전달하는 값
			return "/0522/ex07";
		}
		
		@RequestMapping("ex08")
		public String ex08(RedirectAttributes ra) {
			ra.addFlashAttribute("name" , "java");
			ra.addFlashAttribute("age" , 30);
			ra.addFlashAttribute("num" , 100);
			return "redirect:/sample/ex07";
		}
		
		@RequestMapping("ex09")
		public @ResponseBody String ex09() {			
			return "hello world";	// JSON {key:value}
		}
		
		@RequestMapping("ex10")
		public @ResponseBody SampleDTO ex10() {
			SampleDTO dto = new SampleDTO();
			dto.setName("java");
			dto.setAge(20);
			return dto;
		}
		
		@RequestMapping("ex11")
		public String ex11() {		
			return "/0522/ex11Form";
	}
		
		@RequestMapping("ex11Pro")
		public String ex11Pro(MultipartFile save , HttpServletRequest request) {
			String uploadPath = request.getRealPath("/resources/upload");
			// MultipartRequest - 업로드 선처리
			System.out.println(save.getOriginalFilename());	// 업로드 파일명
			System.out.println(save.getSize());	// 업로드 파일크기
			// 									  test.png
			File copy = new File(uploadPath + "//" + save.getOriginalFilename());
			String fileExtension = save.getOriginalFilename().substring(save.getOriginalFilename().lastIndexOf('.') + 1);
			List<String> allowedExtensions = Arrays.asList("jpg", "jpeg", "png");
				 if (!allowedExtensions.contains(fileExtension)) {
					 if (copy.exists()) {
						 return "error";
			        }
				return "error";
			}
			try {
			save.transferTo(copy);
			}catch(Exception e) {e.printStackTrace();}
			return "/0522/ex11Pro";
		}
		
		@RequestMapping("ex12Pro")
		public String ex12Pro(MultipartFile [] save) {
			System.out.println(save[0].getOriginalFilename());
			System.out.println(save[1].getOriginalFilename());
			System.out.println(save[2].getOriginalFilename());

			List<MultipartFile> fileList = Arrays.asList(save);
			List<String> fileExtensions = new ArrayList<>();
			
	        for (MultipartFile file : fileList) {
	            fileExtensions.add(file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf('.') + 1));
	        }
	        List<String> allowedExtensions = Arrays.asList("jpg", "jpeg", "png" , "");
	        for (String fileExtension : fileExtensions) {
	            if (!allowedExtensions.contains(fileExtension)) {
	            	if(fileList.contains(fileList)) {
					 return "error";
		        }
	            	return "error";
	        }	            
	    }
	        for (int i = 0; i < fileList.size(); i++) {
	        	try {
	            fileList.get(i).transferTo(new File("c://upload//" + fileList.get(i).getOriginalFilename()));
	        	}catch(Exception e) {e.printStackTrace();}
	        }
			return "/0522/ex12Pro";
		}
}