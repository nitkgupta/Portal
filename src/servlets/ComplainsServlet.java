package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ComplainBean;
import dao.Complain;
import dao.ComplainImpl;

/**
 * Servlet implementation class ComplainsServlet
 */
public class ComplainsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String complain = request.getParameter("t1");
		ComplainImpl dao = new ComplainImpl();
		ComplainBean bean = new ComplainBean();
		bean.setComplain(complain);
		String result = dao.createComplain(bean);
	}

}
