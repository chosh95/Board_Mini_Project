package kr.co.choboard.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.choboard.beans.UserBean;
import kr.co.choboard.mapper.UserMapper;

@Repository
public class UserDao {

	@Autowired
	private UserMapper userMapper;
	
	public String checkUserIdExist(String user_id) {
		return userMapper.checkUserIdExist(user_id);
	}
	
	public String checkNicknameExist(String user_nickname) {
		return userMapper.checkNicknameExist(user_nickname);
	}
	
	public void insertUserBean(UserBean signInUserBean) {
		userMapper.insertUserBean(signInUserBean);
	}
	
	public UserBean loginUser(UserBean tempLoginUserBean) {
		return userMapper.loginUser(tempLoginUserBean);
	}
	
	public UserBean getUpdateUser(int user_idx) {
		return userMapper.getUpdateUser(user_idx);
	}
	
	public void updateUserInfo(UserBean updateUserBean) {
		userMapper.updateUserInfo(updateUserBean);
	}
}
