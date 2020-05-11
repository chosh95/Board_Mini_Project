package kr.co.choboard.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.choboard.beans.ContentBean;
import kr.co.choboard.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	@GetMapping("/board/main")
	public String main(@RequestParam("board_info_idx") int board_info_idx, Model model) {
		model.addAttribute("board_info_idx",board_info_idx);
		return "board/main";
	}
	
	@GetMapping("/board/read")
	public String read() {
		return "board/read";
	}
	
	@GetMapping("/board/create")
	public String create(@ModelAttribute("createContentBean") ContentBean createContentBean,
						 @RequestParam("board_info_idx") int board_info_idx) {
		createContentBean.setContent_board_idx(board_info_idx);
		return "board/create";
	}
	
	@PostMapping("/board/create_pro")
	public String create_pro(@Valid @ModelAttribute("createContentBean") ContentBean createContentBean, BindingResult result) {
		if(result.hasErrors()) {
			return "board/create";
		}
		
		boardService.addContentInfo(createContentBean);
		
		return "board/create_success";
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
