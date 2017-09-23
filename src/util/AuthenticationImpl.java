package util;


import bean.UserBean;
import dao.UserImpl;

public class AuthenticationImpl implements Authentication {

	@Override
	public boolean authenticate(UserBean bean) {
		String id = bean.getUserId();
		//id = id.trim();
		UserImpl dao = new UserImpl();
		UserBean resultBean = dao.findByID(id);
		System.out.println(bean.getUserId());
		System.out.println(bean.getPassword());
		if(resultBean!=null){
			if (resultBean.getUserId().equalsIgnoreCase(id)) {
				return true;
			} else {
				return false;
			}	
		}
		else {
			return false;
		}
	}

	@Override
	public int authorize(String userID) {
		UserImpl dao = new UserImpl();
		UserBean bean = dao.findByID(userID);
		return bean.getUserType();
	}

	@Override
	public boolean changeLoginStatus(UserBean bean, int loginStatus) {
		UserImpl dao = new UserImpl();
		UserBean beanData = dao.findByID(bean.getUserId());
		beanData.setLoginStatus(loginStatus);
		boolean result = dao.updateUser(beanData);
		return result;
	}
	
}
