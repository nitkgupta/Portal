package dao;

import java.util.ArrayList;

import bean.ChildProtectionBean;

public interface ChildProtection {
	String createChildProtection(ChildProtectionBean bean);
	 
	int deleteChildProtection(ArrayList<String> li );
	 
	boolean updateChildProtection(ChildProtectionBean bean);
	 
	ChildProtectionBean findByID(String caseId);
	 
	ArrayList<ChildProtectionBean> findAll();
}
