package dao;

import java.util.ArrayList;

import bean.MinistryBean;

public interface Ministry {
	String createMinistry(MinistryBean bean);
	 
	int deleteMinistry(ArrayList<String> li );
	 
	//boolean updateMinistry(MinistryBean bean);
	 
	MinistryBean findByID(String caseId);
	 
	ArrayList<MinistryBean> findAll();
}