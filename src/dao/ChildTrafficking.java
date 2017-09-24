package dao;

import java.util.ArrayList;

import bean.ChildTrafickingBean;


public interface ChildTrafficking {
	 
	int deleteChildTraficking(ArrayList<String> li );
	 
	boolean updateChildTraficking(ChildTrafickingBean bean);
	 
	ChildTrafickingBean findByID(String caseId);
	 
	ArrayList<ChildTrafickingBean> findAll();

	String createChildTraficking(ChildTrafickingBean bean);
}
