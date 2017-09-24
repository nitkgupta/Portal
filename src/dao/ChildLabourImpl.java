package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import util.DatabaseConn;

import bean.ChildLabourBean;

public class ChildLabourImpl implements ChildLabour {
	// Gets DB Connection object from con.ata.util.DBUtil
	Connection con = DatabaseConn.getConnection();

	@Override
	public String createChildLabour(ChildLabourBean bean) {
		try {
			System.out.println("1-----------");
			PreparedStatement ps1 = con.prepareStatement("SELECT * from ID");
			System.out.println("2-----------");
			ResultSet rs = ps1.executeQuery();
			System.out.println("3-----------");
			rs.next();
			int max = rs.getInt(1);
			ps1 = con.prepareStatement("UPDATE ID SET C_L_id=? where C_L_id=?");
			ps1.setInt(1, max + 1);
			ps1.setInt(2, max);

			System.out.println(ps1.executeUpdate());
			System.out.println(max);

			String id = "CL" + max;

			PreparedStatement ps = con.prepareStatement("INSERT INTO Child_Labour VALUES (?,?,?,?,?,?,?,?)");
			ps.setString(1, id);
			ps.setString(2, bean.getName());
			ps.setString(3, bean.getAddress());
			ps.setString(4, bean.getNgoId());
			ps.setString(5, bean.getGender());
			ps.setString(6, bean.getCaseStatus());
			ps.setInt(7, bean.getPin());
			ps.setInt(8, bean.getAge());

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
	public int deleteChildLabour(ArrayList<String> li) {
		int r1 = 0;
		for (String caseId : li) {

			try {
  				PreparedStatement ps = con.prepareStatement("DELETE FROM Child_Labour where caseId=?");
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
	public boolean updateChildLabour(ChildLabourBean bean) {
		try {
			PreparedStatement ps = con
					.prepareStatement("UPDATE Child_Labour SET ngoid=?, casestatus=? where caseId=?");
			ps.setString(1, bean.getNgoId());
			ps.setString(2, bean.getCaseStatus());
			ps.setString(3, bean.getCaseId());
			int r1 = ps.executeUpdate();
			if (r1 > 0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public ChildLabourBean findByID(String caseId) {
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM Child_Labour WHERE caseId=?");
			ps.setString(1, caseId);
			ResultSet rs = ps.executeQuery();
			rs.next();
			ChildLabourBean bean = new ChildLabourBean();
			bean.setCaseId(rs.getString(1));
			bean.setName(rs.getString(2));
			bean.setAddress(rs.getString(3));
			bean.setNgoId(rs.getString(4));
			bean.setGender(rs.getString(5));
			bean.setCaseStatus(rs.getString(6));
			bean.setPin(rs.getInt(7));
			bean.setAge(rs.getInt(8));
			return bean;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<ChildLabourBean> findAll() {
		ArrayList<ChildLabourBean> li = new ArrayList<ChildLabourBean>();
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM Child_Labour");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ChildLabourBean bean = new ChildLabourBean();
				bean.setCaseId(rs.getString(1));
				bean.setName(rs.getString(2));
				bean.setAddress(rs.getString(3));
				bean.setNgoId(rs.getString(4));
				bean.setGender(rs.getString(5));
				bean.setCaseStatus(rs.getString(6));
				bean.setPin(rs.getInt(7));
				bean.setAge(rs.getInt(8));
				li.add(bean);
			}
			return li;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
