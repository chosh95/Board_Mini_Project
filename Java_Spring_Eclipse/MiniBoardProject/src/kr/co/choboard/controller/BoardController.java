package kr.co.choboard.controller;

import java.util.List;

import javax.annotation.Resource;
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
import kr.co.choboard.beans.PageBean;
import kr.co.choboard.beans.UserBean;
import kr.co.choboard.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	@Resource(name="loginUserBean")
	private UserBean loginUserBean;
	
	@GetMapping("/board/main")
	public String main(@RequestParam("board_info_idx") int board_info_idx, 
						@RequestParam(value="page", defaultValue="1") int page,
						Model model) {
		model.addAttribute("board_info_idx",board_info_idx);
		
		String board_info_name = boardService.getBoardName(board_info_idx);
		model.addAttribute("board_info_name",board_info_name);
		
		List<ContentBean> list = boardService.getContentList(board_info_idx, page);
		model.addAttribute("contentList", list);
		
		PageBean pageBean = boardService.getContentCnt(board_info_idx, page);
		model.addAttribute("pageBean", pageBean);
		
		model.addAttribute("page", page);
		
		return "board/main";
	}
	
	@GetMapping("/board/read")
	public String read(@RequestParam("board_info_idx") int board_info_idx,
						@RequestParam("content_idx") int content_idx,
						@RequestParam("page") int page, 
						Model model) {
		
		model.addAttribute("board_info_idx", board_info_idx);
		model.addAttribute("content_idx", content_idx);
		
		ContentBean contentBean = boardService.getContent(content_idx);
		model.addAttribute("contentBean",contentBean);
		
		model.addAttribute("loginUserBean",loginUserBean);
		model.addAttribute("page", page);
		
		return "board/read";
	}
	
	@GetMapping("/board/not_writer")
	public String not_writer() {
		return "board/not_writer";
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
	public String update(@RequestParam("board_info_idx") int board_info_idx,
						 @RequestParam("content_idx") int content_idx,
						 @ModelAttribute("updateContentBean") ContentBean updateContentBean,
						 @RequestParam("page") int page,
						 Model model) {
		
		model.addAttribute("board_info_idx", board_info_idx);
		model.addAttribute("content_idx", content_idx);
		model.addAttribute("page", page);
		
		ContentBean tempContentBean = boardService.getContent(content_idx);
		updateContentBean.setContent_writer_name(tempContentBean.getContent_writer_name());
		updateContentBean.setContent_date(tempContentBean.getContent_date());
		updateContentBean.setContent_subject(tempContentBean.getContent_subject());
		updateContentBean.setContent_text(tempContentBean.getContent_text());
		updateContentBean.setContent_file(tempContentBean.getContent_file());
		updateContentBean.setContent_writer_idx(tempContentBean.getContent_writer_idx());
		updateContentBean.setContent_idx(content_idx);
		updateContentBean.setContent_board_idx(board_info_idx);
		return "board/update";
	}
	
	@PostMapping("/board/update_pro")
	public String update_pro(@Valid @ModelAttribute("updateContentBean") ContentBean updateContentBean, BindingResult result,
							@RequestParam("page") int page, Model model) {
		
		model.addAttribute("page", page);
		
		if(result.hasErrors()) {
			return "board/update";
		}
		boardService.updateContent(updateContentBean);
		return "board/update_success";
	}
	
	@GetMapping("/board/delete")
	public String delete(@RequestParam("board_info_idx") int board_info_idx,
						 @RequestParam("content_idx") int content_idx,
						 Model model) {
		
		boardService.deleteContent(content_idx);
		
		model.addAttribute("board_info_idx", board_info_idx);
		return "board/delete";
	}
	
}
