package dao;

import java.util.ArrayList;

import bean.WomenReportsBean;


public interface WomenReports {
	String createWomenReports(WomenReportsBean bean);
	 
	int deleteWomenReports(ArrayList<String> li );
	 
	boolean updateWomenReportst(WomenReportsBean bean);
	 
	WomenReportsBean findByID(String caseId);
	 
	ArrayList<WomenReportsBean> findAll();
}
