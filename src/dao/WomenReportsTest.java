package dao;

import java.util.ArrayList;

import bean.WomenReportsBean;

public class WomenReportsTest {

	public static void main(String[] args) {
		delete();

	}

	private static void create() {
		WomenReportsBean bean = new WomenReportsBean();
		bean.setName("Test");
		bean.setCaseId("caseId");
		bean.setArea("area");
		bean.setNgoId("ngoId");
		bean.setPin(122001);
		bean.setStation("station");
		bean.setStatus("status");
		WomenREportsImpl dao = new WomenREportsImpl();
		dao.createWomenReports(bean);
	}

	private static void delete() {
		WomenREportsImpl dao = new WomenREportsImpl();
		ArrayList<String> li = new ArrayList<String>();
		li.add("caseid");
		System.out.println(dao.deleteWomenReports(li));
	}

	private static void update() {
		WomenREportsImpl dao = new WomenREportsImpl();
		WomenReportsBean bean = new WomenReportsBean();
		bean.setName("Test");
		bean.setCaseId("caseId");
		bean.setArea("area");
		bean.setNgoId("ngoId");
		bean.setPin(122001);
		bean.setStation("station");
		bean.setStatus("status");
		dao.updateWomenReportst(bean);
	}

	private static void getById() {
		WomenREportsImpl dao = new WomenREportsImpl();
		WomenReportsBean bean = dao.findByID("caseid");
		System.out.println(bean.getCaseId() + bean.getName());
	}

	private static void getAllById() {
		WomenREportsImpl dao = new WomenREportsImpl();
		ArrayList<WomenReportsBean> li = dao.findAll();
		for (WomenReportsBean bean : li)
			System.out.println(bean.getCaseId() + bean.getNgoId());
	}
}
