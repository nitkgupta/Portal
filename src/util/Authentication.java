package util;

import bean.UserBean;

public interface Authentication {
	boolean authenticate(UserBean bean);
	int authorize(String userID);
	boolean changeLoginStatus(UserBean bean, int loginStatus);
}
