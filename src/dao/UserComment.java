package dao;

import java.util.ArrayList;

import bean.UserCommentsBean;


public interface UserComment {
	String createUserComment(UserCommentsBean bean);
	 
	int deleteUserComment(ArrayList<String> li );
	 
	boolean updateUserComment(UserCommentsBean bean);
	 
	UserCommentsBean findByID(String caseId);
	 
	ArrayList<UserCommentsBean> findAll();
}

