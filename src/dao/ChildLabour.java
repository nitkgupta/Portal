package dao;

import java.util.ArrayList;

import bean.ChildLabourBean;

public interface ChildLabour {
	String createChildLabour(ChildLabourBean bean);
	 
	int deleteChildLabour(ArrayList<String> li );
	 
	boolean updateChildLabour(ChildLabourBean bean);
	 
	ChildLabourBean findByID(String caseId);
	 
	ArrayList<ChildLabourBean> findAll();
}
