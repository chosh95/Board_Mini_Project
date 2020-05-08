package kr.co.choboard.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.choboard.beans.UserBean;
import kr.co.choboard.dao.UserDao;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	@Resource(name="loginUserBean")
	private UserBean loginUserBean;
	
	public boolean checkUserIdExist(String user_id) {
		String user_name =  userDao.checkUserIdExist(user_id);
		if(user_name == null) 
			return true;
		else
			return false;
	}
	
	public boolean checkNicknameExist(String user_nickname) {
		String user_name = userDao.checkNicknameExist(user_nickname);
		if(user_name==null)
			return true;
		else
			return false;
	}
	
	public void insertUserBean(UserBean signInUserBean) {
		userDao.insertUserBean(signInUserBean);
	}
	
	public void loginUser(UserBean tempLoginUserBean) {
		UserBean tempLoginUserBean2 = userDao.loginUser(tempLoginUserBean);
		if(tempLoginUserBean2 != null) {
			loginUserBean.setUser_idx(tempLoginUserBean2.getUser_idx());
			loginUserBean.setUser_name(tempLoginUserBean2.getUser_name());
			loginUserBean.setLogin(true);
		}
	}
	
	public void getUpdateUserBean(UserBean updateUserBean) {
		UserBean tmpUpdateUserBean = userDao.getUpdateUser(loginUserBean.getUser_idx());
		updateUserBean.setUser_id(tmpUpdateUserBean.getUser_id());
		updateUserBean.setUser_name(tmpUpdateUserBean.getUser_name());
		updateUserBean.setUser_idx(tmpUpdateUserBean.getUser_idx());
	}
	
	public void updateUserInfo(UserBean updateUserBean) {
		updateUserBean.setUser_idx(loginUserBean.getUser_idx());
		
		userDao.updateUserInfo(updateUserBean);
	}
}
