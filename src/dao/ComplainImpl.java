package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;

import bean.ComplainBean;
import util.DatabaseConn;

public class ComplainImpl implements Complain {
	java.sql.Connection con = DatabaseConn.getConnection();

	@Override
	public String createComplain(ComplainBean bean) {
		try {
			PreparedStatement ps1 = con.prepareStatement("SELECT * from ID");
			ResultSet rs = ps1.executeQuery();
			rs.next();
			int max = rs.getInt(9);
			ps1 = con.prepareStatement("UPDATE ID SET complain_id=? where complain_id=?");
			ps1.setInt(1, max + 1);
			ps1.setInt(2, max);

			System.out.println(ps1.executeUpdate());
			System.out.println(max);

			String id = "CT" + max;
			PreparedStatement ps = con.prepareStatement("insert into complains values(?,?,?,?,?)");
			ps.setString(1, ""+max);
			ps.setString(2, bean.getNgoid());
			ps.setString(3, bean.getMin_id());
			ps.setString(4, bean.getType());
			ps.setString(5, bean.getComplain());
			int a = ps.executeUpdate();
			if (a > 0)
				return ""+max;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "FAIL";
	}

	@Override
	public int deleteComplain(ArrayList<String> li) {
		int r1 = 0;
		for (String userid : li) {
			try {
				PreparedStatement ps = con.prepareStatement("Delete from Complains where comp_id=?");
				ps.setString(1, userid);
				r1 = ps.executeUpdate();
				return r1;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return r1;
	}

	@Override
	public boolean updateComplain(ComplainBean bean) {
		int r1;
		try {
			PreparedStatement ps=con.prepareStatement("update complains set comp_id=?, ngoid=?, min_id=?, type=?, complain=? where comp_id=?");
			ps.setString(1, bean.getComp_id());
			ps.setString(2, bean.getNgoid());
			ps.setString(3, bean.getMin_id());
			ps.setString(4, bean.getType());
			ps.setString(5, bean.getComplain());
			r1=ps.executeUpdate();
			if(r1>0)
				return true;
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return false;
	}

	@Override
	public ComplainBean findByID(String caseId) {
		try {
			PreparedStatement ps=con.prepareStatement("select * from complains where comp_id=?");
			ps.setString(1, caseId);
			ComplainBean bean=new ComplainBean();
			ResultSet rs=ps.executeQuery();
			rs.next();
			bean.setComp_id(rs.getString(1));
			bean.setNgoid(rs.getString(2));
			bean.setMin_id(rs.getString(3));
			bean.setType(rs.getString(4));
			bean.setComplain(rs.getString(5));
			return bean;
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<ComplainBean> findAll() {
		ArrayList<ComplainBean> li=new ArrayList<ComplainBean>();
		try {
			PreparedStatement ps=con.prepareStatement("select * from complains");
			ComplainBean bean=new ComplainBean();
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				bean.setComp_id(rs.getString(1));
				bean.setNgoid(rs.getString(2));
				bean.setMin_id(rs.getString(3));
				bean.setType(rs.getString(4));
				bean.setComplain(rs.getString(5));
				li.add(bean);
			}
			return li;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return li;
	}
	public ArrayList<ComplainBean> findAllbyMinistry(String min_id) {
		ArrayList<ComplainBean> li=new ArrayList<ComplainBean>();
		try {
			PreparedStatement ps=con.prepareStatement("select * from complains where min_id=?");
			ComplainBean bean=new ComplainBean();
			ResultSet rs=ps.executeQuery();// ok
			while(rs.next()) {
				bean.setComp_id(rs.getString(1));
				bean.setNgoid(rs.getString(2));
				bean.setMin_id(rs.getString(3));
				bean.setType(rs.getString(4));
				bean.setComplain(rs.getString(5));
				li.add(bean);
			}
			return li;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return li;
	}
	
}
