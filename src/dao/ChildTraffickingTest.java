package dao;

import java.util.ArrayList;

import bean.ChildTrafickingBean;

public class ChildTraffickingTest {

	public static void main(String[] args) {
		delete();

	}

	private static void create() {
		ChildTrafickingBean bean = new ChildTrafickingBean();
		bean.setName("Test");
		bean.setArea("Area");
		bean.setNgoId("ngoId");
		bean.setCaseStatus("Pending");
		bean.setPin(160001);
		bean.setAge(12);
		ChildTrafickingImpl dao = new ChildTrafickingImpl();
		dao.createChildTraficking(bean);
	}

	private static void delete() {
		ChildTrafickingImpl dao = new ChildTrafickingImpl();
		ArrayList<String> li = new ArrayList<String>();
		li.add("CL1001");
		System.out.println(dao.deleteChildTraficking(li));
	}

	private static void update() {
		ChildTrafickingImpl dao = new ChildTrafickingImpl();
		ChildTrafickingBean bean = new ChildTrafickingBean();
		bean.setNgoId("NGO1001");
		bean.setCaseStatus("Pending");
		bean.setCaseId("Cl1001");
		dao.updateChildTraficking(bean);
	}

	private static void getById() {
		ChildTrafickingImpl dao = new ChildTrafickingImpl();
		ChildTrafickingBean bean = dao.findByID("CL1001");
		System.out.println(bean.getCaseId() + bean.getArea());
	}

	private static void getAllById() {
		ChildTrafickingImpl dao = new ChildTrafickingImpl();
		ArrayList<ChildTrafickingBean> li = dao.findAll();
		for (ChildTrafickingBean bean : li)
			System.out.println(bean.getCaseId() + bean.getArea());
	}
}
