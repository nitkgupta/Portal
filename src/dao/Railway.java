package dao;

import java.util.ArrayList;

import bean.RailwayBean;

public interface Railway {
	String createRailway(RailwayBean bean);
	 
	int deleteRailway(ArrayList<String> li );
	 
	boolean updateRailway(RailwayBean bean);
	 
	RailwayBean findByID(String caseId);
	 
	ArrayList<RailwayBean> findAll();
}
