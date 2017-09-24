package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.DatabaseConn;
import bean.NGOBean;
import bean.TrainingBean;

public class NgoImpl implements Ngo {
	// Gets DB Connection object from con.ata.util.DBUtil
				Connection con = DatabaseConn.getConnection();

	@Override
	public String createNgo(NGOBean bean) {
		try {
			System.out.println("1-----------");
			PreparedStatement ps1 = con.prepareStatement("SELECT * from ID");
			System.out.println("2-----------");
			ResultSet rs = ps1.executeQuery();
			System.out.println("3-----------");
			rs.next();
			int max = rs.getInt(5);
			ps1 = con.prepareStatement("UPDATE ID SET NGO_Id=? where NGO_Id=?");
			ps1.setInt(1, max + 1);
			ps1.setInt(2, max);

			System.out.println(ps1.executeUpdate());
			System.out.println(max);

			String id = "NG" + max;

			PreparedStatement ps = con.prepareStatement("INSERT INTO NGO VALUES (?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, id);
			ps.setString(2, bean.getName());
			ps.setString(3, bean.getArea());
			ps.setString(4, bean.getType());
			ps.setInt(5, bean.getPin());
			ps.setString(6, bean.getState());
			ps.setString(7, bean.getEmail());
			ps.setInt(8, bean.getTotalFund());
			ps.setInt(9, bean.getFundRecieved());
			ps.setInt(10, bean.getFundUsed());
			
			
			
			

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
	public int deleteNgo(ArrayList<String> li) {
		int r1 = 0;
		for (String ngoId : li) {

			try {
  				PreparedStatement ps = con.prepareStatement("DELETE FROM NGO where ngoId=?");
				ps.setString(1,ngoId);
				r1 = ps.executeUpdate();
				return r1;

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return r1;
	}

	@Override
	public boolean updateNgo(NGOBean bean) {
		try {
			PreparedStatement ps = con
					.prepareStatement("UPDATE NGO SET area=?,type=?,pincode =?,email=?,totalFund=?,fundReceived=?,fundUsed=? where ngoId=?");
			ps.setString(1, bean.getArea());
			ps.setString(2, bean.getType());
			ps.setInt(3, bean.getPin());
			ps.setString(4, bean.getEmail());
			ps.setInt(4, bean.getTotalFund());
			ps.setInt(5, bean.getFundRecieved());
			ps.setInt(6, bean.getFundUsed());
			int r1 = ps.executeUpdate();
			if (r1 > 0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public NGOBean findByID(String caseId) {
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM NGO WHERE ngoId=?");
			ps.setString(1, caseId );
			ResultSet rs = ps.executeQuery();
			rs.next();
			NGOBean bean = new NGOBean();
			bean.setNgoId(rs.getString(1));
			bean.setName(rs.getString(2));
			bean.setArea(rs.getString(3));
			bean.setType(rs.getString(4));
			bean.setPin(rs.getInt(5));
			bean.setState(rs.getString(6));
			bean.setEmail(rs.getString(7));
			bean.setTotalFund(rs.getInt(5));
			bean.setFundRecieved(rs.getInt(5));
			bean.setFundUsed(rs.getInt(5));
			
			
			
			
			return bean;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<NGOBean> findAll() {
		ArrayList<NGOBean> li = new ArrayList<NGOBean>();
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM NGO");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				NGOBean bean = new NGOBean();
				bean.setNgoId(rs.getString(1));
				bean.setName(rs.getString(2));
				bean.setArea(rs.getString(3));
				bean.setType(rs.getString(4));
				bean.setPin(rs.getInt(5));
				bean.setState(rs.getString(6));
				bean.setEmail(rs.getString(7));
				bean.setTotalFund(rs.getInt(5));
				bean.setFundRecieved(rs.getInt(5));
				bean.setFundUsed(rs.getInt(5));
				
				
				li.add(bean);
				
				
			}
			return li;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
