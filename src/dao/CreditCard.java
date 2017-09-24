package dao;

import java.util.ArrayList;

import bean.CreditCardBean;

public interface CreditCard {
	String createCreditCardBean(CreditCardBean bean);
	 
	int deleteCreditCardBean(ArrayList<String> li );
	 
	boolean updateCreditCardBean(CreditCardBean bean);
	 
	CreditCardBean findByID(String caseId);
	 
	ArrayList<CreditCardBean> findAll();
}
