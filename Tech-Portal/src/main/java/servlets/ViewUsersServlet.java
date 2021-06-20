package servlets;
import java.io.*;
import java.sql.*;
import javax.servlet.*;

import sql.UserInfo;

public class ViewUsersServlet extends GenericServlet{
	private static final long serialVersionUID = 1L;

	public void service(ServletRequest req,ServletResponse res) throws IOException,ServletException{
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("Select * from " + UserInfo.TABLE_USERS);
			ResultSet rs = ps.executeQuery();
			RequestDispatcher rd = req.getRequestDispatcher("Sample.jsp");
			rd.include(req, res);
			pw.println("<div class=\"d-flex justify-content-center text-success display-4\">Registered Users</div>");
			pw.println("<div class=\"table table-hover d-flex justify-content-center\">\r\n" + 
					"	<table>\r\n" + 
					"	<tr>\r\n" + 
					"	\r\n" + 
					"	<th>First Name</th>\r\n" + 
					"	<th>Last Name</th>\r\n" + 
					"	<th>Country</th>\r\n" +
					"   <th>City</th>\r\n" + 
					"   <th>Street</th>\r\n" +
					"   <th>Phone</th>\r\n" + 
					"	<th>Email</th><br/>\r\n" + 
					"	</tr>");
			while(rs.next()){
				
				String firstname = rs.getString(1);
				String lastname = rs.getString(2);
				String country = rs.getString(3);
				String city = rs.getString(4);
				String street = rs.getString(5);
				String phone = rs.getString(6);
				String email = rs.getString(7);
				pw.println("<tr><td>"+firstname+"</td>");
				pw.println("<td>"+lastname+"</td>");
				pw.println("<td>"+country+"</td>");
				pw.println("<td>"+city+"</td>");
				pw.println("<td>"+street+"</td>");
				pw.println("<td>"+phone+"</td>");
				pw.println("<td>"+email+"</td></tr>");
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