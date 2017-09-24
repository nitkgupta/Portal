package dao;

import java.util.ArrayList;

import bean.TrainingBean;


public interface Training {
	String createTraining(TrainingBean bean);
	 
	int deleteTraining(ArrayList<String> li );
	 
	boolean updateTraining(TrainingBean bean);
	 
	TrainingBean findByID(String caseId);
	 
	ArrayList<TrainingBean> findAll();
}
