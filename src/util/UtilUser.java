package util;

import bean.UserBean;

public interface UtilUser {
	String login(UserBean bean);
	boolean logout(String userId);
	String changePassword(UserBean bean, String newPassword);
	String register(UserBean bean);
}
