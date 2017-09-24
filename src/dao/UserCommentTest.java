package dao;

import java.util.ArrayList;

import bean.UserCommentsBean;

public class UserCommentTest {

	public static void main(String[] args) {
		delete();

	}

	private static void create() {
		UserCommentsBean bean = new UserCommentsBean();
		bean.setCommentId("id1");
		bean.setUserId("userId");
		bean.setNgoId("ngoId");
		bean.setComment("comment");
		bean.setRating(5);
		UserCommentImpl dao = new UserCommentImpl();
		dao.createUserComment(bean);
	}

	private static void delete() {
		UserCommentImpl dao = new UserCommentImpl();
		ArrayList<String> li = new ArrayList<String>();
		li.add("id1");
		System.out.println(dao.deleteUserComment(li));
	}

	private static void update() {
		UserCommentImpl dao = new UserCommentImpl();
		UserCommentsBean bean = new UserCommentsBean();
		bean.setCommentId("id1");
		bean.setUserId("userId");
		bean.setNgoId("ngoId");
		bean.setComment("comment");
		bean.setRating(5);
		dao.updateUserComment(bean);
	}

	private static void getById() {
		UserCommentImpl dao = new UserCommentImpl();
		UserCommentsBean bean = dao.findByID("id1");
		System.out.println(bean.getCommentId() + bean.getNgoId());
	}

	private static void getAllById() {
		UserCommentImpl dao = new UserCommentImpl();
		ArrayList<UserCommentsBean> li = dao.findAll();
		for (UserCommentsBean bean : li)
			System.out.println(bean.getCommentId() + bean.getNgoId());
	}
}
