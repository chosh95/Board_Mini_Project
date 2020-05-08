package kr.co.choboard.controller;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.choboard.beans.UserBean;
import kr.co.choboard.service.UserService;
import kr.co.choboard.validator.UserValidator;

@Controller
public class UserController {

	
	@Autowired
	private UserService userService;
	
	@Resource(name="loginUserBean")
	private UserBean loginUserBean;
	
	@GetMapping("user/login")
	public String login(@ModelAttribute("tempLoginUserBean") UserBean tempLoginUserBean,
						@RequestParam(value = "fail", defaultValue="false") boolean fail,
						Model model) {
		model.addAttribute("fail",fail);

		return "user/login";
	}
	
	@PostMapping("user/login_pro")
	public String login_pro(@Valid @ModelAttribute("tempLoginUserBean") UserBean tempLoginUserBean, BindingResult result) {
		if(result.hasErrors()) {
			return "user/login";
		}

		userService.loginUser(tempLoginUserBean);
		
		if(loginUserBean.isLogin()==true) {
			return "user/login_success";
		}
		else {
			return "user/login_fail";
		}
	}
	
	@GetMapping("user/update")
	public String update(@ModelAttribute("updateUserBean") UserBean updateUserBean) {
		userService.getUpdateUserBean(updateUserBean);
		return "user/update";
	}
	
	@PostMapping("user/update_pro")
	public String update_pro(@Valid @ModelAttribute("updateUserBean") UserBean updateUserBean, BindingResult result) {
		if(result.hasErrors()) {
			return "user/update";
		}
		userService.updateUserInfo(updateUserBean);
		
		return "user/update_success";
	}
	
	@GetMapping("user/logout")
	public String logout() {
		loginUserBean.setLogin(false);
		return "user/logout";
	}
	
	@GetMapping("user/not_login")
	public String not_login() {
		return "user/not_login";
	}
	
	@GetMapping("user/signIn")
	public String signIn(@ModelAttribute("signInUserBean") UserBean userBean) {
		return "user/signIn";
	}
	
	@PostMapping("user/signIn_pro")
	public String signIn_pro(@Valid @ModelAttribute("signInUserBean") UserBean signInUserBean, BindingResult result) {
		if(result.hasErrors()) {
			return "user/signIn";
		}
		userService.insertUserBean(signInUserBean);
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
