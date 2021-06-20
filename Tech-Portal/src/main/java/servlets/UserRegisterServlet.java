package servlets;

import java.sql.*;
import javax.servlet.*;

import info.TechPortalInfo;
import sql.UserInfo;

import java.io.*;

public class UserRegisterServlet extends GenericServlet {
	private static final long serialVersionUID = 1L;

	public void service(ServletRequest req, ServletResponse res) throws IOException, ServletException {
		PrintWriter pw = res.getWriter();
		res.setContentType(TechPortalInfo.CONTENT_TYPE_TEXT_HTML);

		String password = req.getParameter(UserInfo.COLUMN_PASSWORD);
		String firstname = req.getParameter(UserInfo.COLUMN_FIRSTNAME);
		String lastname = req.getParameter(UserInfo.COLUMN_LASTNAME);
		String country = req.getParameter(UserInfo.COLUMN_COUNTRY);
		String city = req.getParameter(UserInfo.COLUMN_CITY);
		String street = req.getParameter(UserInfo.COLUMN_STREET);
		String phone = req.getParameter(UserInfo.COLUMN_PHONE);
		String email = req.getParameter(UserInfo.COLUMN_EMAIL);
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con
					.prepareStatement("insert into " + UserInfo.TABLE_USERS + "  values(?,?,?,?,?,?,?,?,?)");
			ps.setString(1, firstname);
			ps.setString(2, lastname);
			ps.setString(3, country);
			ps.setString(4, city);
			ps.setString(5, street);
			ps.setString(6, phone);
			ps.setString(7, email);
			ps.setString(8, password);
			ps.setInt(9, 2);
			int k = ps.executeUpdate();
			if (k == 1) {
				RequestDispatcher rd = req.getRequestDispatcher("Sample.jsp");
				rd.include(req, res);
				pw.println("<div class='d-flex justify-content-center text-success display-4'>User Registered Successfully</div>");
			} else {
				RequestDispatcher rd = req.getRequestDispatcher("userreg");
				rd.include(req, res);
				pw.println("<div class='d-flex justify-content-center text-success display-4'>Sorry for interruption! Register again</div>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}