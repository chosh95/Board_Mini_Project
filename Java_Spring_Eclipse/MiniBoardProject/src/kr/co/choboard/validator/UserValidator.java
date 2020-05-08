package kr.co.choboard.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import kr.co.choboard.beans.UserBean;

public class UserValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return UserBean.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		UserBean userBean = (UserBean) target;

		String beanName = errors.getObjectName();
		
		if (beanName.equals("signInUserBean") || beanName.equals("updateUserBean")) {
			if (userBean.getUser_pw().contentEquals(userBean.getUser_pw2()) == false) {
				errors.rejectValue("user_pw", "NotEquals");
				errors.rejectValue("user_pw2", "NotEquals");
			}

			if (userBean.isNicknameExist() == false) {
				errors.rejectValue("user_nickname", "NicknameExist");
			}
		}
		
		if(beanName.equals("signInUserBean")) {
			if (userBean.isUserIdExist() == false) {
				errors.rejectValue("user_id", "UserIdExist");
			}
		}
			
	}
}
