package dao;

import java.util.ArrayList;

import bean.DonateFoodBean;


public interface DonateFood {
	String createDonateFoodBean(DonateFoodBean bean);
	 
	int deleteDonateFoodBean(ArrayList<String> li );
	 
	boolean updateDonateFoodBean(DonateFoodBean bean);
	 
	DonateFoodBean findByID(String caseId);
	 
	ArrayList<DonateFoodBean> findAll();
}
