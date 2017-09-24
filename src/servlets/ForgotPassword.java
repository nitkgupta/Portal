package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.UserBean;
import dao.UserImpl;
import mails.Mailer;

/**
 * Servlet implementation class ForgotPassword
 */
public class ForgotPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		PrintWriter out = response.getWriter();
		out.println("Welcome");
		try {
			UserImpl dao = new UserImpl();
			UserBean bean = dao.findByID(id);
			if(bean != null)
			{
				String s = "Dear "+bean.getName()+"\n"+"Your password Reset Request:\n\t"+"Id: "+id+"\nPassword: "+bean.getPassword();
				Mailer mail = new Mailer();
				mail.send("javammu@gmail.com", "dellintel", bean.getEmail(), "Reset Password", s);
				out.println("Sent");
			}
			else {
				out.println("Invalid User ID \n Do you have a account? Register Now");
			}
			

		} catch (RuntimeException e) {
			out.println("Error");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

}
