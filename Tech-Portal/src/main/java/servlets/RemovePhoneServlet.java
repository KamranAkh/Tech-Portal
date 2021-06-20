package servlets;

import java.sql.*;
import javax.servlet.*;

import info.TechPortalInfo;
import sql.ProductInfo;

import java.io.*;

public class RemovePhoneServlet extends GenericServlet {

	private static final long serialVersionUID = 1L;

	public void service(ServletRequest req, ServletResponse res) throws IOException, ServletException {
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		res.setContentType(TechPortalInfo.CONTENT_TYPE_TEXT_HTML);
		String barcode = req.getParameter("barcode");
		try {
			Connection con = DBConnection.getCon();
				
			PreparedStatement ps2 = con.prepareStatement(
					"delete from " + ProductInfo.TABLE_PRODUCT + "  where " + ProductInfo.COLUMN_BARCODE + "=?");
			ps2.setString(1, barcode);
			int k = ps2.executeUpdate();
			if (k == 1) {
				RequestDispatcher rd2 = req.getRequestDispatcher("Sample.jsp");
				rd2.include(req, res);
				pw.println("<div class=\"d-flex justify-content-center text-success display-4\">Phone Removed Successfully</div>");
				pw.println("<div class=\"d-flex justify-content-center text-success display-4\"><a href=\"RemovePhone.jsp\">Remove more Phones</a></div>");

			} else {
				RequestDispatcher rd2 = req.getRequestDispatcher("Sample.jsp");
				rd2.include(req, res);
				pw.println("<div class=\"d-flex justify-content-center text-success display-4\">Phone Not Available In The Store</div>");
				pw.println("<div class=\"d-flex justify-content-center text-success display-4\"><a href=\"RemovePhone.jsp\">Remove more Phones</a></div>");
			}
				
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
