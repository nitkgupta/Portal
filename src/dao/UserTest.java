package dao;

import java.util.ArrayList;

import bean.UserBean;

public class UserTest {
	public static void main(String[] args) {
		create();

	}

	private static void create() {
		UserBean bean = new UserBean();
		bean.setName("Test");
		bean.setPassword("Test");
		bean.setAge(12);
		bean.setAdhar("123456789");
		bean.setUserType(2);
		bean.setGender("Male");
		bean.setAddress("Mullana");
		bean.setPin(133207);
		bean.setEmail("a@a.com");
		bean.setPhone("123456789");
		UserImpl dao = new UserImpl();
		dao.createUser(bean);
	}

	private static void delete() {
		UserImpl dao = new UserImpl();
		ArrayList<String> li = new ArrayList<String>();
		li.add("User1002");
		System.out.println(dao.deleteUser(li));
	}

	private static void update() {
		UserImpl dao = new UserImpl();
		UserBean bean = new UserBean();
		bean.setName("xyz");
		bean.setPassword("123");
		bean.setUserType(1);
		bean.setAddress("mullana");
		bean.setPin(12344);
		bean.setEmail("jjs@mm");
		bean.setPhone("12334556");
		bean.setEduLevel(12);
		
		dao.updateUser(bean);
	}

	private static void getById() {
		UserImpl dao = new UserImpl();
		UserBean bean = dao.findByID("CP1002");
		System.out.println("123"+bean.getUserId() + bean.getAddress());
	}

	private static void getAllById() {
		UserImpl dao = new UserImpl();
		ArrayList<UserBean> li = dao.findAll();
		for (UserBean bean : li)
			System.out.println(bean.getUserId() + bean.getAddress());
	}
}



