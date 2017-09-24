package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.UserCommentsBean;
import util.DatabaseConn;

public class UserCommentImpl implements UserComment {
	Connection con = DatabaseConn.getConnection();
	@Override
	public String createUserComment(UserCommentsBean bean) {
		try {
			System.out.println("1-----------");
			PreparedStatement ps1 = con.prepareStatement("SELECT * from ID");
			System.out.println("2-----------");
			ResultSet rs = ps1.executeQuery();
			System.out.println("3-----------");
			rs.next();
			int max = rs.getInt(2);
			ps1 = con.prepareStatement("UPDATE ID SET Comment_id=? where Comment_id=?");
			ps1.setInt(1, max + 1);
			ps1.setInt(2, max);

			System.out.println(ps1.executeUpdate());
			System.out.println(max);

			String id = "CT" + max;

			PreparedStatement ps = con.prepareStatement("INSERT INTO user_comments VALUES (?,?,?,?,?)");
			ps.setString(1, id);
			ps.setString(2, bean.getUserId());
			ps.setString(3, bean.getNgoId());
			ps.setString(4, bean.getComment());
			ps.setInt(5, bean.getRating());

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
	public int deleteUserComment(ArrayList<String> li) {
		int r1 = 0;
		for (String commentId : li) {

			try {
  				PreparedStatement ps = con.prepareStatement("DELETE FROM User_Comments where commentid=?");
				ps.setString(1, commentId);
				r1 = ps.executeUpdate();
				return r1;

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return r1;
	}

	@Override
	public boolean updateUserComment(UserCommentsBean bean) {
		try {
			PreparedStatement ps = con
					.prepareStatement("UPDATE User_comments SET userid=?, ngoid=?, comment=?' rating=? where commentId=?");
			ps.setString(1, bean.getUserId());
			ps.setString(2, bean.getNgoId());
			ps.setString(3, bean.getComment());
			ps.setInt(4, bean.getRating());
			ps.setString(5, bean.getCommentId());
			int r1 = ps.executeUpdate();
			if (r1 > 0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;		
	}

	@Override
	public UserCommentsBean findByID(String caseId) {
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM Child_Traficking WHERE caseId=?");
			ps.setString(1, caseId);
			ResultSet rs = ps.executeQuery();
			rs.next();
			UserCommentsBean bean=new UserCommentsBean();
			bean.setCommentId(rs.getString(1));
			bean.setUserId(rs.getString(2));
			bean.setNgoId(rs.getString(3));
			bean.setComment(rs.getString(4));
			bean.setRating(rs.getInt(5));
			
			return bean;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public ArrayList<UserCommentsBean> findAll() {
		ArrayList<UserCommentsBean> li = new ArrayList<UserCommentsBean>();
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM User_Comments");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				UserCommentsBean bean = new UserCommentsBean();
				bean.setCommentId(rs.getString(1));
				bean.setUserId(rs.getString(2));
				bean.setNgoId(rs.getString(3));
				bean.setComment(rs.getString(4));
				bean.setRating(rs.getInt(5));
				
				li.add(bean);
				
				
			}
			return li;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
