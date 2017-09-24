package dao;

import java.util.ArrayList;

import bean.DonationBean;


public interface Donation {
	String createDonation(DonationBean bean);
	 
	int deleteDonation(ArrayList<String> li );
	 
	boolean updateDonation(DonationBean bean);
	 
	DonationBean findByID(String caseId);
	 
	ArrayList<DonationBean> findAll();
}
