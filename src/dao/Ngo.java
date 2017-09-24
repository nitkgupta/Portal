package dao;

import java.util.ArrayList;

import bean.NGOBean;


public interface Ngo {
	String createNgo(NGOBean bean);
	 
	int deleteNgo(ArrayList<String> li );
	 
	boolean updateNgo(NGOBean bean);
	 
	NGOBean findByID(String caseId);
	 
	ArrayList<NGOBean> findAll();
}
