package kr.co.choboard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.choboard.dao.UserDao;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	public boolean checkUserIdExist(String user_id) {
		String user_name =  userDao.checkUserIdExist(user_id);
		if(user_name == null) 
			return true;
		else
			return false;
	}
}
