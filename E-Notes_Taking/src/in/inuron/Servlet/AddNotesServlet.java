package in.inuron.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.inuron.DAO.postDAO;
import in.inuron.db.DBConnect;
import in.inuron.user.Post;

@WebServlet("/AddNotesServlet")
public class AddNotesServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int uid=Integer.parseInt(request.getParameter("uid"));
		String title=request.getParameter("title");
		String content=request.getParameter("content");

		postDAO dao= new postDAO(DBConnect.getConect());
		boolean f=dao.addNotes(title, content, uid);
		if (f) {
			System.out.println("data inserted successfully");
			response.sendRedirect("showNotes.jsp");
		}
		else {
			System.out.println("data not inserted successfully.");
		}
	}

}
