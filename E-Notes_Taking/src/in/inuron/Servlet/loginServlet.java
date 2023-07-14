package in.inuron.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.inuron.DAO.UserDao;
import in.inuron.db.DBConnect;
import in.inuron.user.UserDetails;
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("uemail");
		String password=request.getParameter("upassword");


		UserDetails userDetails =new UserDetails();
		userDetails.setEmailString(email);
		userDetails.setPasswordString(password);

		UserDao dao=new UserDao(DBConnect.getConect());
		UserDetails user=dao.loginUser(userDetails);
		if (user!= null) {
			HttpSession session=request.getSession();
			session.setAttribute("userD", user);
			response.sendRedirect("home.jsp");
		}
		else {
			HttpSession session=request.getSession();
			session.setAttribute("login-failed", "Invalid Username and Password");
			response.sendRedirect("login.jsp");
		}
	}
	

}
