package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.DatabaseConn;
import bean.ChildProtectionBean;
import bean.ChildTrafickingBean;

public class ChildTrafickingImpl implements ChildTrafficking  {
	// Gets DB Connection object from con.ata.util.DBUtil
			Connection con = DatabaseConn.getConnection();
	@Override
	public String createChildTraficking(ChildTrafickingBean bean) {
		try {
			System.out.println("1-----------");
			PreparedStatement ps1 = con.prepareStatement("SELECT * from ID");
			System.out.println("2-----------");
			ResultSet rs = ps1.executeQuery();
			System.out.println("3-----------");
			rs.next();
			int max = rs.getInt(2);
			ps1 = con.prepareStatement("UPDATE ID SET C_T_id=? where C_T_id=?");
			ps1.setInt(1, max + 1);
			ps1.setInt(2, max);

			System.out.println(ps1.executeUpdate());
			System.out.println(max);

			String id = "CT" + max;

			PreparedStatement ps = con.prepareStatement("INSERT INTO Child_Traficking VALUES (?,?,?,?,?,?,?,?)");
			ps.setString(1, id);
			ps.setString(2, bean.getName());
			ps.setInt(3, bean.getAge());
			ps.setString(4, bean.getArea());
			ps.setString(5, bean.getCaseType());
			ps.setString(6, bean.getCaseStatus());
		    ps.setString(7, bean.getNgoId());
			ps.setInt(8, bean.getPin());
			
			

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
	public int deleteChildTraficking(ArrayList<String> li) {
		int r1 = 0;
		for (String caseId : li) {

			try {
  				PreparedStatement ps = con.prepareStatement("DELETE FROM Child_Protection where caseId=?");
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
	public boolean updateChildTraficking(ChildTrafickingBean bean) {
		try {
			PreparedStatement ps = con
					.prepareStatement("UPDATE Child_Trafiking SET ngoid=?, status=? where caseId=?");
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
	public ChildTrafickingBean findByID(String caseId) {
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM Child_Traficking WHERE caseId=?");
			ps.setString(1, caseId);
			ResultSet rs = ps.executeQuery();
			rs.next();
			ChildTrafickingBean bean = new ChildTrafickingBean();
			bean.setCaseId(rs.getString(1));
			bean.setName(rs.getString(2));
			bean.setAge(rs.getInt(3));
			bean.setArea(rs.getString(4));
			bean.setCaseType(rs.getString(5));
			bean.setCaseStatus(rs.getString(6));
			//bean.setGender(rs.getString(5));
			bean.setNgoId(rs.getString(7));
			bean.setPin(rs.getInt(8));
			
			return bean;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<ChildTrafickingBean> findAll() {
		ArrayList<ChildTrafickingBean> li = new ArrayList<ChildTrafickingBean>();
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM Child_Traficking");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ChildTrafickingBean bean = new ChildTrafickingBean();
				bean.setCaseId(rs.getString(1));
				bean.setName(rs.getString(2));
				bean.setAge(rs.getInt(3));
				bean.setArea(rs.getString(4));
				bean.setCaseType(rs.getString(5));
				bean.setCaseStatus(rs.getString(6));
				bean.setNgoId(rs.getString(7));
				bean.setPin(rs.getInt(8));
				li.add(bean);
				
				
			}
			return li;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
