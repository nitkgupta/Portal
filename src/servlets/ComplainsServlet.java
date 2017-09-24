package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.ComplainBean;
import bean.UserBean;
import dao.ComplainImpl;
import mails.Mailer;

/**
 * Servlet implementation class ComplainsServlet
 */
public class ComplainsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String complain = request.getParameter("t1");
		ComplainImpl dao = new ComplainImpl();
		ComplainBean bean = new ComplainBean();
		bean.setComplain(complain);
		String result = dao.createComplain(bean);
		
		HttpSession ses = request.getSession();
		UserBean uBean =(UserBean)ses.getAttribute("userBean");
		if(!result.equals("FAIL")) {
			String emailBody = "Dear "+uBean.getName()+"\nYour Complain has been Raised. Our team is working to resolve it soon.\nPlease note your Complain Id: "+result;
			Mailer mail = new Mailer();
			mail.send("javammu@gmail.com", "dellintel", uBean.getEmail(), "Complain Raised", emailBody);
			out.println("Please note your complain Id:\t"+result+"\nA copy of this Complain Ticket is emailed to You.");
			

		}
		else {
			out.println("Some Error");
		}
	}

}
