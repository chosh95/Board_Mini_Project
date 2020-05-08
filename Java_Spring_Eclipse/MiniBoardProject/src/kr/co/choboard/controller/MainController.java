package kr.co.choboard.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.choboard.beans.UserBean;

@Controller
public class MainController {
	
	@GetMapping("/")
	public String index() {
		return "redirect:/main";
	}
	
	@GetMapping("/main")
	public String main() {
		return "main";
	}
}
