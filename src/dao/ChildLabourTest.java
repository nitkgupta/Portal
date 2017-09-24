package dao;

import java.util.ArrayList;

import bean.ChildLabourBean;

public class ChildLabourTest {

	public static void main(String[] args) {
		delete();

	}

	private static void create() {
		ChildLabourBean bean = new ChildLabourBean();
		bean.setName("Test");
		bean.setAddress("Dhaba Near Mullana Bus Stand");
		bean.setGender("Male");
		bean.setCaseStatus("Pending");
		bean.setPin(160001);
		bean.setAge(12);
		ChildLabourImpl dao = new ChildLabourImpl();
		dao.createChildLabour(bean);
	}

	private static void delete() {
		ChildLabourImpl dao = new ChildLabourImpl();
		ArrayList<String> li = new ArrayList<String>();
		li.add("CL1001");
		System.out.println(dao.deleteChildLabour(li));
	}

	private static void update() {
		ChildLabourImpl dao = new ChildLabourImpl();
		ChildLabourBean bean = new ChildLabourBean();
		bean.setNgoId("NGO1001");
		bean.setCaseStatus("Pending");
		bean.setCaseId("Cl1001");
		dao.updateChildLabour(bean);
	}

	private static void getById() {
		ChildLabourImpl dao = new ChildLabourImpl();
		ChildLabourBean bean = dao.findByID("CL1001");
		System.out.println(bean.getCaseId() + bean.getAddress());
	}

	private static void getAllById() {
		ChildLabourImpl dao = new ChildLabourImpl();
		ArrayList<ChildLabourBean> li = dao.findAll();
		for (ChildLabourBean bean : li)
			System.out.println(bean.getCaseId() + bean.getAddress());
	}
}
