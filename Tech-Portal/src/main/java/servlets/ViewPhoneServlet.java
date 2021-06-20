package servlets;
import java.io.*;
import java.sql.*;
import javax.servlet.*;

import sql.ProductInfo;

public class ViewPhoneServlet extends GenericServlet{
	private static final long serialVersionUID = 1L;

	public void service(ServletRequest req,ServletResponse res) throws IOException,ServletException{
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("Select * from " + ProductInfo.TABLE_PRODUCT);
			ResultSet rs = ps.executeQuery();
			RequestDispatcher rd = req.getRequestDispatcher("ViewPhone.jsp");
			rd.include(req, res);
			pw.println("<div class=\"d-flex justify-content-center text-success display-4\">Phones Available In Our Store</div>");
			pw.println("<div class=\"table table-hover d-flex justify-content-center\">\r\n" + 
					"	<table>\r\n" + 
					"	<tr>\r\n" + 
					"	\r\n" + 
					"	<th>Barcode</th>\r\n" + 
					"	<th>Brand</th>\r\n" + 
					"	<th>Model</th>\r\n" + 
					"	<th>Price</th>\r\n" + 
					"	<th>Quantity</th><br/>\r\n" + 
					"	</tr>");
			while(rs.next())
			{
				String barcode = rs.getString(1);
				String brand = rs.getString(2);
				String model = rs.getString(3);
				int price = rs.getInt(4);
				int Qty = rs.getInt(5);
				pw.println("<tr><td>"+barcode+"</td>");
				pw.println("<td>"+brand+"</td>");
				pw.println("<td>"+model+"</td>");
				pw.println("<td>"+price+"</td>");
				pw.println("<td>"+Qty+"</td></tr>");
			}
			pw.println("</table>\r\n" + 
					"	</div>");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}