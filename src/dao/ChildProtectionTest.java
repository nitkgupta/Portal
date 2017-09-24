package dao;

import java.util.ArrayList;

import bean.ChildProtectionBean;

public class ChildProtectionTest {

	public static void main(String[] args) {
		delete();

	}

	private static void create() {
		ChildProtectionBean bean = new ChildProtectionBean();
		bean.setName("Test");
		bean.setAddress("Dhaba Near Mullana Bus Stand");
		bean.setGender("Male");
		bean.setCaseStatus("Pending");
		bean.setPin(160001);
		bean.setAge(12);
		ChildProtectionImpl dao = new ChildProtectionImpl();
		dao.createChildProtection(bean);
	}

	private static void delete() {
		ChildProtectionImpl dao = new ChildProtectionImpl();
		ArrayList<String> li = new ArrayList<String>();
		li.add("CL1001");
		System.out.println(dao.deleteChildProtection(li));
	}

	private static void update() {
		ChildProtectionImpl dao = new ChildProtectionImpl();
		ChildProtectionBean bean = new ChildProtectionBean();
		bean.setNgoId("NGO1001");
		bean.setCaseStatus("Pending");
		bean.setCaseId("Cl1001");
		dao.updateChildProtection(bean);
	}

	private static void getById() {
		ChildProtectionImpl dao = new ChildProtectionImpl();
		ChildProtectionBean bean = dao.findByID("CL1001");
		System.out.println(bean.getCaseId() + bean.getAddress());
	}

	private static void getAllById() {
		ChildProtectionImpl dao = new ChildProtectionImpl();
		ArrayList<ChildProtectionBean> li = dao.findAll();
		for (ChildProtectionBean bean : li)
			System.out.println(bean.getCaseId() + bean.getAddress());
	}
}
