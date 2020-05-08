package kr.co.choboard.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.co.choboard.beans.UserBean;

public interface UserMapper {

	@Select("select user_name " + 
			"from user_table " +
			"where user_id = #{user_id}")
	String checkUserIdExist(String user_id);
	
	@Select("select user_name " +
			"from user_table " +
			"where user_nickname = #{user_nickname}")
	String checkNicknameExist(String user_nickname);
	
	@Insert("insert into user_table (user_idx, user_id, user_name, user_pw, user_nickname, user_email) " + 
			"values(user_seq.nextval, #{user_id}, #{user_name}, #{user_pw}, #{user_nickname}, #{user_email})")
	void insertUserBean(UserBean signInUserBean);
	
	@Select("select user_idx, user_name " +
			"from user_table " + 
			"where user_id=#{user_id} and user_pw=#{user_pw}")
	UserBean loginUser(UserBean tempLoginUserBean);	
	
	@Select("select user_name, user_id " + 
			"from user_table " + 
			"where user_idx=#{user_idx}")
	UserBean getUpdateUser(int user_idx);
	
	@Update("update user_table " +
			"set user_pw = #{user_pw}, user_email = #{user_email}, " + 
			"user_nickname = #{user_nickname} " +
			"where user_idx = #{user_idx}")
	void updateUserInfo(UserBean updateUserBean);
}
