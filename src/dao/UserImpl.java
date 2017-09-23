package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.DatabaseConn;
import bean.UserBean;

public class UserImpl implements User {
	// Gets DB Connection object from con.ata.util.DBUtil
	Connection con = DatabaseConn.getConnection();

	@Override
	public String createUser(UserBean bean) {
		try {
			System.out.println("1-----------");
			PreparedStatement ps1 = con.prepareStatement("SELECT * from ID");
			System.out.println("2-----------");
			ResultSet rs = ps1.executeQuery();
			System.out.println("3-----------");
			rs.next();
			int max = rs.getInt(6);
			ps1 = con.prepareStatement("UPDATE ID SET User_id=? where User_id=?");
			ps1.setInt(1, max + 1);
			ps1.setInt(2, max);

			System.out.println(ps1.executeUpdate());
			System.out.println(max);

			String id = "User" + max;

			PreparedStatement ps = con.prepareStatement("INSERT INTO User VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, id);
			ps.setString(2, bean.getName());
			ps.setString(3, bean.getPassword());
			ps.setInt(4, bean.getAge());
			ps.setString(5, bean.getAdhar());
			ps.setInt(6, bean.getUserType());
			ps.setString(7, bean.getGender());
			ps.setString(8, bean.getAddress());
			ps.setInt(9, bean.getPin());
			ps.setString(10, bean.getEmail());
			ps.setString(11, bean.getPhone());
			ps.setInt(12, bean.getEduLevel());
			ps.setInt(13, 0);

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
	public int deleteUser(ArrayList<String> li) {
		int r1 = 0;
		for (String userId : li) {

			try {
				PreparedStatement ps = con.prepareStatement("DELETE FROM User where userId=?");
				ps.setString(1, userId);
				r1 = ps.executeUpdate();
				return r1;

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return r1;
	}

	@Override
	public boolean updateUser(UserBean bean) {
		try {
			PreparedStatement ps = con.prepareStatement(
					"UPDATE User SET name=?, password=?,usertype=?,address=?,pincode=?,email=?,phone=?,educationLevel=?,loginStatus=? where userId=?");
			ps.setString(1, bean.getName());
			ps.setString(2, bean.getPassword());
			ps.setInt(3, bean.getUserType());
			ps.setString(4, bean.getAddress());
			ps.setInt(5, bean.getPin());
			ps.setString(6, bean.getEmail());
			ps.setString(7, bean.getPhone());
			ps.setInt(8, bean.getEduLevel());
			ps.setInt(9, bean.getLoginStatus());
			ps.setString(10, bean.getUserId());

			int r1 = ps.executeUpdate();
			if (r1 > 0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public UserBean findByID(String userId) {
		try {
			System.out.println("rs start");
			PreparedStatement ps = con.prepareStatement("SELECT * FROM User WHERE userId=?");
			
			
			ps.setString(1, userId);
			ResultSet rs = ps.executeQuery();
			UserBean bean = null;
			System.out.println("rs out+++++++++++++"+rs==null);
			if (rs != null && rs.next()!=false) {
				System.out.println("rs not null+++++++++++++"+rs==null);
				//rs.next();
				bean = new UserBean();
				bean.setUserId(rs.getString(1));
				bean.setName(rs.getString(2));
				bean.setPassword(rs.getString(3));
				bean.setAge(rs.getInt(4));
				bean.setAdhar(rs.getString(5));
				bean.setUserType(rs.getInt(6));
				bean.setGender(rs.getString(7));
				bean.setAddress(rs.getString(8));
				bean.setPin(rs.getInt(9));
				bean.setEmail(rs.getString(10));
				bean.setPhone(rs.getString(11));
				bean.setEduLevel(rs.getInt(12));
				bean.setLoginStatus(rs.getInt(13));
			}
			System.out.println("rs null");
			return bean;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<UserBean> findAll() {
		ArrayList<UserBean> li = new ArrayList<UserBean>();
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM User");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				UserBean bean = new UserBean();
				bean.setUserId(rs.getString(1));
				bean.setName(rs.getString(2));
				bean.setPassword(rs.getString(3));
				bean.setAge(rs.getInt(4));
				bean.setAdhar(rs.getString(5));
				bean.setUserType(rs.getInt(6));
				bean.setGender(rs.getString(7));
				bean.setAddress(rs.getString(8));
				bean.setPin(rs.getInt(9));
				bean.setEmail(rs.getString(10));
				bean.setPhone(rs.getString(11));
				bean.setEduLevel(rs.getInt(12));
				bean.setLoginStatus(rs.getInt(13));
				li.add(bean);
			}
			return li;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
