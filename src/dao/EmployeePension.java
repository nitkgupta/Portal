package dao;

import java.util.ArrayList;

import bean.EmployeePensionBean;


public interface EmployeePension {
	String createEmployeePension(EmployeePensionBean bean);
	 
	int deleteEmployeePension(ArrayList<String> li );
	 
	boolean updateEmployeePension(EmployeePensionBean bean);
	 
	EmployeePensionBean findByID(String caseId);
	 
	ArrayList<EmployeePensionBean> findAll();
}
