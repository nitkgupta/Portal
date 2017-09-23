package dao;

import java.util.ArrayList;

import bean.UserBean;


public interface User {
	String createUser(UserBean bean);
	 
	int deleteUser(ArrayList<String> li );
	 
	boolean updateUser(UserBean bean);
	 
	UserBean findByID(String userId);
	 
	ArrayList<UserBean> findAll();
}
