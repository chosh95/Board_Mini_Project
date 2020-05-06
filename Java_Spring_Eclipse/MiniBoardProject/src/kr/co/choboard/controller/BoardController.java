package kr.co.choboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {

	@GetMapping("/board/main")
	public String main() {
		return "board/main";
	}
	
	@GetMapping("/board/read")
	public String read() {
		return "board/read";
	}
	
	@GetMapping("/board/create")
	public String create() {
		return "board/create";
	}
	
	@GetMapping("/board/update")
	public String update() {
		return "board/update";
	}
	
	@GetMapping("/board/delete")
	public String delete() {
		return "board/delete";
	}
}
