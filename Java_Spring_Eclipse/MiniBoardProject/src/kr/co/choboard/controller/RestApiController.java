package kr.co.choboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import kr.co.choboard.service.UserService;

@RestController
public class RestApiController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/user/checkUserIdExist/{user_id}")
	public String checkUserIdExist(@PathVariable String user_id) {
		boolean chk = userService.checkUserIdExist(user_id);
		
		return chk + "";
	}
	
	@GetMapping("/user/checkNicknameExist/{user_nickname}")
	public String checkNicknameExist(@PathVariable String user_nickname) {
		boolean chk = userService.checkNicknameExist(user_nickname);
		return chk + "";
	}
}
