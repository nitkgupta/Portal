package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.DatabaseConn;
import bean.ChildLabourBean;
import bean.RailwayBean;

public class RailwayImpl implements Railway {
	// Gets DB Connection object from con.ata.util.DBUtil
				Connection con = DatabaseConn.getConnection();
			

	@Override
	public String createRailway(RailwayBean bean) {
		try {
			/*System.out.println("1-----------");
			PreparedStatement ps1 = con.prepareStatement("SELECT * from ID");
			System.out.println("2-----------");
			ResultSet rs = ps1.executeQuery();
			System.out.println("3-----------");
			rs.next();
			int max = rs.getInt(6);
			ps1 = con.prepareStatement("UPDATE ID SET Railway_id=? where Railway_id=?");
			ps1.setInt(1, max + 1);
			ps1.setInt(2, max);

			System.out.println(ps1.executeUpdate());
			System.out.println(max);

			String id = "Railway_id" + max; 
			
			//Change Id everywhere...
			*/

			PreparedStatement ps = con.prepareStatement("INSERT INTO Railway VALUES (?,?,?,?,?,?)");
			ps.setString(1, bean.getUserid());
			ps.setString(2, bean.getName());
			ps.setString(3, bean.getStationid());
			ps.setString(4, bean.getComment());
			ps.setString(5, bean.getNgoid());
			ps.setString(6, bean.getArea());

			int a = ps.executeUpdate();
			if (a > 0) {
				return bean.getUserid();
			} else {
				return "FAIL";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "FAIL";
	}

	@Override
	public int deleteRailway(ArrayList<String> li) {
		int r1 = 0;
		for (String UserId : li) {

			try {
  				PreparedStatement ps = con.prepareStatement("DELETE FROM Railway where UserId=?");
				ps.setString(1, UserId);
				r1 = ps.executeUpdate();
				return r1;

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return r1;
	}

	@Override
	public boolean updateRailway(RailwayBean bean) {
		try {
			PreparedStatement ps = con
					.prepareStatement("UPDATE Railway SET userid=?, name=?,stationid=?,comment=?,ngoid=?,area=? where userId=?");
			ps.setString(1, bean.getUserid());
			ps.setString(2, bean.getName());
			ps.setString(3, bean.getStationid());
			ps.setString(4, bean.getComment());
			ps.setString(5, bean.getNgoid());
			ps.setString(6, bean.getArea());
			ps.setString(7, bean.getUserid());
			
			int r1 = ps.executeUpdate();
			if (r1 > 0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public RailwayBean findByID(String RailwayId) {
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM Railway WHERE userId=?");
			ps.setString(1, RailwayId);
			ResultSet rs = ps.executeQuery();
			rs.next();
			RailwayBean bean = new RailwayBean();
			bean.setUserid(rs.getString(1));
			bean.setName(rs.getString(2));
			bean.setStationid(rs.getString(3));
			bean.setComment(rs.getString(4));
			bean.setNgoid(rs.getString(5));
			bean.setArea(rs.getString(6));
			return bean;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<RailwayBean> findAll() {
		ArrayList<RailwayBean> li = new ArrayList<RailwayBean>();
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM Railway");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				RailwayBean bean = new RailwayBean();
				bean.setUserid(rs.getString(1));
				bean.setName(rs.getString(2));
				bean.setStationid(rs.getString(3));
				bean.setComment(rs.getString(4));
				bean.setNgoid(rs.getString(5));
				bean.setArea(rs.getString(6));
				li.add(bean);
			}
			return li;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
