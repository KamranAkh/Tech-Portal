package servlets;
import java.io.*;
import java.sql.*;
import javax.servlet.*;

import info.TechPortalInfo;
import sql.ProductInfo;
public class BuyPhoneServlet extends GenericServlet{

	private static final long serialVersionUID = 1L;

	public void service(ServletRequest req,ServletResponse res) throws IOException,ServletException
	{
		PrintWriter pw = res.getWriter();
		res.setContentType(TechPortalInfo.CONTENT_TYPE_TEXT_HTML);
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("Select * from " + ProductInfo.TABLE_PRODUCT);
			ResultSet rs = ps.executeQuery();
			RequestDispatcher rd = req.getRequestDispatcher("ViewPhone.jsp");
			rd.include(req, res);
			pw.println("<div class=\"d-flex justify-content-center text-success display-4\">Phone Available In Our Store</div>");
			pw.println("<div class=\"table table-hover d-flex justify-content-center\"><form action=\"buys\" method=\"post\">");
			pw.println("<table>\r\n" + 
					"			<tr>\r\n" + 
					"				<th>Select</th>\r\n" + 	
					"				<th>Barcode</th>\r\n" + 
					"				<th>Brand</th>\r\n" + 
					"				<th>Model</th>\r\n" + 
					"				<th>Price</th>\r\n" + 
					"				<th>Available</th>\r\n" + 
					"				<th>Quantity</th>\r\n" + 
					"			</tr>");
			int i=0;
			while(rs.next())
			{
				String barcode = rs.getString(1);
				String brand = rs.getString(2);
				String model = rs.getString(3);
				int price = rs.getInt(4);
				int Avl = rs.getInt(5);
				i=i+1;
				String n = "checked"+ Integer.toString(i);
				String q = "qty"+Integer.toString(i);
				pw.println("<tr>\r\n" + 
						"				<td>\r\n" + 
						"					<input type=\"checkbox\" name="+n+" value=\"pay\">\r\n" +
						"				</td>");
				pw.println("<td>"+barcode+"</td>");
				pw.println("<td>"+brand+"</td>");
				pw.println("<td>"+model+"</td>");
				pw.println("<td>"+price+"</td>");
				pw.println("<td>"+Avl+"</td>");
				pw.println("<td><input type=\"text\" name="+q+" value=\"0\" text-align=\"center\"></td></tr>");
				
			}
			pw.println("</table>\r\n"
					+ "	<div class=\"container\">\r\n"
					+ "		<h2>Card data</h2>\r\n"
					+ "		<form action=\"buys\" method=\"post\">\r\n"
					+ "			<div class=\"form-group\">\r\n"
					+ "				<label>Cardholder Name</label> <input type=\"text\"\r\n"
					+ "					class=\"form-control\" placeholder=\"Enter name\"\r\n"
					+ "					name=\"name\">\r\n"
					+ "			</div>\r\n"
					+ "			<div class=\"form-group\">\r\n"
					+ "				<label>Card number</label> <input type=\"text\"\r\n"
					+ "					class=\"form-control\" placeholder=\"Enter number\"\r\n"
					+ "					name=\"number\">\r\n"
					+ "			</div>\r\n"
					+ "			<div class=\"form-group\">\r\n"
					+ "				<label>Expiration date</label> <input type=\"text\"\r\n"
					+ "					class=\"form-control\" placeholder=\"Enter date\"\r\n"
					+ "					name=\"expiration\">\r\n"
					+ "			</div>\r\n"
					+ "			<div class=\"form-group\">\r\n"
					+ "				<label>Cvv</label> <input type=\"text\"\r\n"
					+ "					class=\"form-control\" placeholder=\"Enter cvv\"\r\n"
					+ "					name=\"cvv\">\r\n"
					+ "			</div>\r\n"
					+ "		<input type=\"submit\" value=\" PAY NOW \">"+"<br/>"
					+ "	</form>\r\n"
					+ "	</div>");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
