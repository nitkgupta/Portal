package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.DatabaseConn;
import bean.WomenReportsBean;

public class WomenREportsImpl implements WomenReports {
	// Gets DB Connection object from con.ata.util.DBUtil
	Connection con = DatabaseConn.getConnection();
	@Override
	public String createWomenReports(WomenReportsBean bean) {
		try {
			/*System.out.println("1-----------");
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

			String id = "NG" + max;*/

			PreparedStatement ps = con.prepareStatement("INSERT INTO Women_Reports VALUES (?,?,?,?,?,?,?)");
			ps.setString(1, bean.getCaseId());
			ps.setString(2, bean.getName());
			ps.setInt(3, bean.getPin());
			ps.setString(4, bean.getNgoId());
			ps.setString(5, bean.getStation());
			ps.setString(6, bean.getArea());
			ps.setString(7, bean.getStatus());
			
			int a = ps.executeUpdate();
			if (a > 0) {
				return bean.getCaseId();
			} else {
				return "FAIL";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "FAIL";
	}

	@Override
	public int deleteWomenReports(ArrayList<String> li) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean updateWomenReportst(WomenReportsBean bean) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public WomenReportsBean findByID(String caseId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<WomenReportsBean> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
