package servlets;

import javax.servlet.*;

import info.TechPortalInfo;
import sql.UserInfo;

import java.io.*;
import java.sql.*;

public class AdminLoginServlet extends GenericServlet {
	private static final long serialVersionUID = 1L;

	public void service(ServletRequest req, ServletResponse res) throws IOException, ServletException {
		PrintWriter pw = res.getWriter();
		res.setContentType(TechPortalInfo.CONTENT_TYPE_TEXT_HTML);
		String email = req.getParameter(UserInfo.COLUMN_EMAIL);
		String password = req.getParameter(UserInfo.COLUMN_PASSWORD);
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM " + UserInfo.TABLE_USERS + " WHERE  "
					+ UserInfo.COLUMN_EMAIL + "=? AND " + UserInfo.COLUMN_PASSWORD + "=? AND "
					+ UserInfo.COLUMN_USERTYPE + "=1");
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				RequestDispatcher rd = req.getRequestDispatcher("Sample.jsp");
			
				rd.include(req, res);
				pw.println("<div class=\"d-flex justify-content-center text-success display-4\">Welcome ADMIN</div>");
				pw.println("<div class=\"d-flex justify-content-center text-success display-4\"><br/><a href=\"AddPhone.jsp\">ADD PHONES</a><br/></div>");
				pw.println("<div class=\"d-flex justify-content-center text-success display-4\"><br/><a href=\"RemovePhone.jsp\">REMOVE PHONES</a><br/></div>");
				pw.println("<div class=\"d-flex justify-content-center text-success display-4\"><br/><a href=\"viewphone\">VIEW PHONES</a></div>");
				pw.println("<div class=\"d-flex justify-content-center text-success display-4\"><br/><a href=\"viewusers\">VIEW USERS</a></div>");
			} else {

				RequestDispatcher rd = req.getRequestDispatcher("Login.jsp");
				rd.include(req, res);
				pw.println("<div class=\"d-flex justify-content-center text-success display-4\">Incorrect Email or Password</div>");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}