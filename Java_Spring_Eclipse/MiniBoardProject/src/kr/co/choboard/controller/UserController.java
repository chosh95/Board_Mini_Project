package kr.co.choboard.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.choboard.beans.UserBean;
import kr.co.choboard.validator.UserValidator;

@Controller
public class UserController {

	@GetMapping("user/login")
	public String login() {
		return "user/login";
	}
	
	@GetMapping("user/signIn")
	public String signIn(@ModelAttribute("signInUserBean") UserBean userBean) {
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
	
	@PostMapping("user/signIn_pro")
	public String signIn_pro(@Valid @ModelAttribute("signInUserBean") UserBean signInUserBean, BindingResult result) {
		if(result.hasErrors()) {
			return "user/signIn";
		}
		return "user/signIn_success";
	}
	
	@GetMapping("user/signIn_cancel")
	public String signIn_cancel() {
		return "user/signIn_cancel";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		UserValidator validator1 = new UserValidator();
		binder.addValidators(validator1);
	}
}
