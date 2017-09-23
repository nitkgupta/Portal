package util;

import bean.UserBean;
import dao.UserImpl;

public class UtilUserImpl implements UtilUser {

	@Override
	public String login(UserBean bean) {
		AuthenticationImpl auth = new AuthenticationImpl();
		boolean login = auth.authenticate(bean);
		if (login && auth.changeLoginStatus(bean, 1)) {
			int type = auth.authorize(bean.getUserId());
			return ""+type;
		} else {
			return "INVALID";
		}
	}

	@Override
	public boolean logout(String userId) {
		UserBean bean = new UserBean();
		bean.setUserId(userId);
		AuthenticationImpl auth = new AuthenticationImpl();
		if (auth.changeLoginStatus(bean, 0)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String changePassword(UserBean bean, String newPassword) {
		UserImpl cd = new UserImpl();
		AuthenticationImpl auth = new AuthenticationImpl();
		boolean passCheck = auth.authenticate(bean);
		if (passCheck) {
			bean.setPassword(newPassword);
			cd.updateUser(bean);
			return "SUCESS";
		} else {
			return "INVALID";
		}
	}

	@Override
	public String register(UserBean bean) {
		UserImpl dao = new UserImpl();

		bean.setUserType(2);
		String id = dao.createUser(bean);

		bean.setUserId(id);
		String result = dao.createUser(bean);
		
		if (id != null && result != null ) {
			return id;
		} else {
			return "FAIL";
		}
	}

}
