package kr.co.choboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

	@GetMapping("user/login")
	public String login() {
		return "user/login";
	}
	
	@GetMapping("user/signIn")
	public String signIn() {
		return "user/signIn";
	}
	
	@GetMapping("user/update")
	public String update() {
		return "user/update";
	}
	
	@GetMapping("user/logout")
	public String logout() {
		return "user/logout";
	}
}
