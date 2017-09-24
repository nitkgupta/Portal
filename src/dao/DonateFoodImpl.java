package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.DonateFoodBean;

public class DonateFoodImpl implements DonateFood {

	@Override
	public String createDonateFoodBean(DonateFoodBean bean) {
		
		return "FAIL";
		
	}

	@Override
	public int deleteDonateFoodBean(ArrayList<String> li) {
		return 0;
	}

	@Override
	public boolean updateDonateFoodBean(DonateFoodBean bean) {
		return false;
	}

	@Override
	public DonateFoodBean findByID(String caseId) {
		return null;
	}

	@Override
	public ArrayList<DonateFoodBean> findAll() {
		return null;
	}

}
