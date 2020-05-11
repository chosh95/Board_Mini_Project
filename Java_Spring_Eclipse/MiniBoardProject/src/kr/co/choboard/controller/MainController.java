package kr.co.choboard.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping("/")
	public String index() {
		return "redirect:/main";
	}
	
	@GetMapping("/main")
	public String main(HttpServletRequest request) {
//		System.out.println(request.getServletContext().getRealPath("/"));
		return "main";
	}
}
