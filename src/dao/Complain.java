package dao;

import java.util.ArrayList;

import bean.ComplainBean;

public interface Complain {
	int deleteComplain(ArrayList<String> li );
	 
	boolean updateComplain(ComplainBean bean);
	 
	ComplainBean findByID(String caseId);
	 
	ArrayList<ComplainBean> findAll();

	String createComplain(ComplainBean bean);

}
