package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.UserBean;
import mails.Mailer;
import util.UtilUserImpl;

/**
 * Servlet implementation class Signup
 */
public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String email=request.getParameter("email");
		String dob = request.getParameter("dob");
		String gender = request.getParameter("gender");
		String password = request.getParameter("password");
		
		String [] ar = dob.split("-");
		int year =Integer.parseInt( ar[2]);
		int age = 2017-year;
		
		
		UserBean bean = new UserBean();
		bean.setName(name);
		bean.setPassword(password);
		bean.setAge(age);
		bean.setGender(gender);
		bean.setEmail(email);
		bean.setUserType(2);
		
		
		UtilUserImpl user = new UtilUserImpl();
		String result_id = user.register(bean);
		
		PrintWriter out = response.getWriter();
		out.println(result_id);
		out.println("Please note your id and follow link in your email for activation");
		Mailer mail = new Mailer();
		String s1="Your Account has been Successfully created."+"\n"+"Following are your credentials"+"\n"+ "UserId: "+result_id+"\n"+"Password: "+bean.getPassword();
		mail.send("javammu@gmail.com", "dellintel", bean.getEmail(),"PEP|Verify Account",s1);
	}

}
