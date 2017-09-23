package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
			// from,password,to,subject,message
			Mailer mail = new Mailer();
			mail.send("javammu@gmail.com", "dellintel", "anurag21j@gmail.com", "Women Harrasmant", id);
			out.println("Sent");

		} catch (RuntimeException e) {
			out.println("Error");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

}
