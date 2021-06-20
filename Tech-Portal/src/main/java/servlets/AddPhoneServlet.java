package servlets;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import info.TechPortalInfo;
import sql.ProductInfo;

public class AddPhoneServlet extends GenericServlet{
	private static final long serialVersionUID = 1L;

	public void service(ServletRequest req,ServletResponse res) throws IOException,ServletException
	{
		PrintWriter pw = res.getWriter();
		
		res.setContentType(TechPortalInfo.CONTENT_TYPE_TEXT_HTML);
		
		try {
			Connection con = DBConnection.getCon();
			
			String barcode = req.getParameter(ProductInfo.COLUMN_BARCODE);
			String brand = req.getParameter(ProductInfo.COLUMN_BRAND);
			String model = req.getParameter(ProductInfo.COLUMN_MODEL);
			int price =Integer.parseInt(req.getParameter(ProductInfo.COLUMN_PRICE));
			int quantity = Integer.parseInt(req.getParameter(ProductInfo.COLUMN_QUANTITY));
			
			PreparedStatement ps2 = con.prepareStatement("insert into " + ProductInfo.TABLE_PRODUCT + "  values(?,?,?,?,?)");
			ps2.setString(1, barcode);
			ps2.setString(2, brand);
			ps2.setString(3, model);
			ps2.setInt(4, price);
			ps2.setInt(5, quantity);
			int k = ps2.executeUpdate();
			if(k != 0 )
			{
				RequestDispatcher rd2 = req.getRequestDispatcher("AddPhone.jsp");
				rd2.include(req, res);
				pw.println("<div class=\"d-flex justify-content-center text-success display-4\">Phone Added Successfully</div>");
			}
			else
			{
				RequestDispatcher rd2 = req.getRequestDispatcher("AddPhone.jsp");
				pw.println("<div class=\"d-flex justify-content-center text-success display-4\">Failed to Add Phone</div>");
				rd2.include(req, res);
			}
				
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
