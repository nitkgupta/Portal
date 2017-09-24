package dao;

import java.util.ArrayList;

import bean.JobsAvailableBean;


public interface JobsAvailable {
	String createJobsAvailable(JobsAvailableBean bean);
	 
	int deleteJobsAvailable(ArrayList<String> li );
	 
	boolean updateJobsAvailable(JobsAvailableBean bean);
	 
	JobsAvailableBean findByID(String caseId);
	 
	ArrayList<JobsAvailableBean> findAll();
}
