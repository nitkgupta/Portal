package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.MinistryBean;
import util.DatabaseConn;

public class MinistryImpl implements Ministry {
	java.sql.Connection con = DatabaseConn.getConnection();

	@Override
	public String createMinistry(MinistryBean bean) {
		try {
			System.out.println("1-----------");
			PreparedStatement ps1 = con.prepareStatement("SELECT * from ID");
			System.out.println("2-----------");
			ResultSet rs = ps1.executeQuery();
			System.out.println("3-----------");
			rs.next();
			// Update this max from database again
			int max = rs.getInt(6);
			ps1 = con.prepareStatement("UPDATE ID SET Ministry_ID=? where Ministry_ID=?");
			ps1.setInt(1, max + 1);
			ps1.setInt(2, max);

			System.out.println(ps1.executeUpdate());
			System.out.println(max);

			String id = "Ministry_ID" + max;

			PreparedStatement ps = con.prepareStatement("INSERT INTO Railway VALUES (?,?,?,?)");
			ps.setString(1, id);
			ps.setString(2, bean.getName());
			ps.setString(3, bean.getEmail());
			ps.setInt(4, bean.getRating());

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
	public int deleteMinistry(ArrayList<String> li) {
		int r1 = 0;
		for (String UserId : li) {
			try {
				PreparedStatement ps = con.prepareStatement("delete from ministry where min_id=?");
				ps.setString(1, UserId);
				return r1;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return r1;
	}

	/*
	 * @Override public boolean updateMinistry(MinistryBean bean) { return
	 * false; }
	 */

	@Override
	public MinistryBean findByID(String caseId) {
		try {
			PreparedStatement ps = con.prepareStatement("select * from ministry where min_id=?");
			ps.setString(1, caseId);
			ResultSet rs = ps.executeQuery();
			rs.next();
			MinistryBean bean = new MinistryBean();
			bean.setMin_id(rs.getString(1));
			bean.setName(rs.getString(2));
			bean.setEmail(rs.getString(3));
			bean.setRating(rs.getInt(4));
			return bean;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<MinistryBean> findAll() {
		ArrayList<MinistryBean> li=new ArrayList<MinistryBean>();
		try {
			PreparedStatement ps=con.prepareStatement("select * from ministry");
			ResultSet rs=ps.executeQuery();
			MinistryBean bean=new MinistryBean();
			while(rs.next()) {
				bean.setMin_id(rs.getString(1));
				bean.setName(rs.getString(2));
				bean.setEmail(rs.getString(3));
				bean.setRating(rs.getInt(4));
				li.add(bean);
			}
			return li;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
