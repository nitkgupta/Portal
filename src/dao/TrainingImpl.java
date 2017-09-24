package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.DatabaseConn;
import bean.ChildProtectionBean;
import bean.TrainingBean;

public class TrainingImpl implements Training {
	// Gets DB Connection object from con.ata.util.DBUtil
			Connection con = DatabaseConn.getConnection();
	@Override
	public String createTraining(TrainingBean bean) {
		try {
			System.out.println("1-----------");
			PreparedStatement ps1 = con.prepareStatement("SELECT * from ID");
			System.out.println("2-----------");
			ResultSet rs = ps1.executeQuery();
			System.out.println("3-----------");
			rs.next();
			int max = rs.getInt(1);
			ps1 = con.prepareStatement("UPDATE ID SET userId=? where userId=?");
			ps1.setInt(1, max + 1);
			ps1.setInt(2, max);

			System.out.println(ps1.executeUpdate());
			System.out.println(max);

			String id = "UT" + max;

			PreparedStatement ps = con.prepareStatement("INSERT INTO Unemployed_Training VALUES (?,?,?,?,?,?,?)");
			ps.setString(1, id);
			ps.setString(2, bean.getCaseId());
			ps.setInt(3, bean.getAge());
			ps.setString(4, bean.getField());
			ps.setString(5, bean.getStartDate());
			ps.setString(6, bean.getEndDate());
			ps.setString(7, bean.getStatus());
			
			
			

			int a = ps.executeUpdate();
			if (a > 0) {
				return id;
			} else {
				return "FAIL";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "FAIL";
	}

	@Override
	public int deleteTraining(ArrayList<String> li) {
		int r1 = 0;
		for (String caseId : li) {

			try {
  				PreparedStatement ps = con.prepareStatement("DELETE FROM Unemployed_Training where caseId=?");
				ps.setString(1, caseId);
				r1 = ps.executeUpdate();
				return r1;

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return r1;
	}

	@Override
	public boolean updateTraining(TrainingBean bean) {
		try {
			PreparedStatement ps = con
					.prepareStatement("UPDATE Unemployed_Training SET training_field=?,end_date=?  status=? where caseId=?");
			ps.setString(1, bean.getField());
			ps.setString(2, bean.getEndDate());
			ps.setString(3, bean.getStatus());
			int r1 = ps.executeUpdate();
			if (r1 > 0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public TrainingBean findByID(String caseId) {
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM Unemployed_Training WHERE caseId=?");
			ps.setString(1, caseId);
			ResultSet rs = ps.executeQuery();
			rs.next();
			TrainingBean bean = new TrainingBean();
			bean.setCaseId(rs.getString(1));
			bean.setUserId(rs.getString(2));
			bean.setAge(rs.getInt(3));
			bean.setField(rs.getString(4));
			bean.setStartDate(rs.getString(5));
			bean.setEndDate(rs.getString(6));
			bean.setStatus(rs.getString(7));
			
			
			return bean;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<TrainingBean> findAll() {
		ArrayList<TrainingBean> li = new ArrayList<TrainingBean>();
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM Unemployed_Training");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				TrainingBean bean = new TrainingBean();
				bean.setCaseId(rs.getString(1));
				bean.setUserId(rs.getString(2));
				bean.setAge(rs.getInt(3));
				bean.setField(rs.getString(4));
				bean.setStartDate(rs.getString(5));
				bean.setEndDate(rs.getString(6));
				bean.setStatus(rs.getString(7));
				
				li.add(bean);
				
				
			}
			return li;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
