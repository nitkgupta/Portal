package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.UserBean;
import dao.UserImpl;
import util.UtilUserImpl;

/**
 * Servlet implementation class LoginServlat
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String id = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(id+password);
		UtilUserImpl user = new UtilUserImpl();
		UserBean bean = new UserBean();
		bean.setUserId(id);
		bean.setPassword(password);
		String result = user.login(bean);
		UserImpl dao = new UserImpl();
		if(result.equalsIgnoreCase("2")) {
			bean = dao.findByID(id);
			HttpSession ses = request.getSession();
			System.out.println("servletlogin    "+ bean.getName()+"  "+bean.getUserId());
			bean.setPassword(null);
			ses.setAttribute("userId", id);
			ses.setAttribute("userBean", bean);
			RequestDispatcher dis=request.getRequestDispatcher("WelcomeUser.jsp");
			dis.forward(request, response);
			
		
		}
		else if(result.equalsIgnoreCase("INVALID")) {
			response.sendRedirect("login.jsp");
			System.out.println(result);
		}
		else if(result.equalsIgnoreCase("0")) {
			bean = dao.findByID(id);
			HttpSession ses = request.getSession();
			System.out.println("servletlogin    "+ bean.getName()+"  "+bean.getUserId());
			bean.setPassword(null);
			ses.setAttribute("userId", id);
			ses.setAttribute("userBean", bean);
			RequestDispatcher dis=request.getRequestDispatcher("WelcomeAdmin.jsp");
			dis.forward(request, response);
		}
	}

}
