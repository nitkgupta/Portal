package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.UtilUserImpl;

/**
 * Servlet implementation class LogoutServlet
 */
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = null;
		String userid = request.getParameter("userid");
		UtilUserImpl user = new UtilUserImpl();
		boolean result = user.logout(userid);
		if (result) {
			HttpSession session = request.getSession(false);
			response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
			response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
			response.setDateHeader("Expires", 0); // Proxies.
			response.setHeader("Pragma", "no-cache");
			if (session != null) {
				session.invalidate();
				rd = request.getRequestDispatcher("index.html");
			}
			rd.forward(request, response);
			return;
		} else {
			response.sendRedirect("Myerror.jsp");
		}
	}

}
