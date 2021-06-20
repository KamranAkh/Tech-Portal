package servlets;

import java.sql.*;
import java.io.*;
import javax.servlet.*;

import info.TechPortalInfo;
import sql.ProductInfo;
import rest.CardDao;
import rest.Card;

public class ReceiptServlet extends GenericServlet {
	private static final long serialVersionUID = 1L;
	
	private CardDao cardDao;
	
	public void init() {
		cardDao = new CardDao();
	}
	
	
	public void service(ServletRequest req, ServletResponse res) throws IOException, ServletException {
		PrintWriter pw = res.getWriter();
		res.setContentType(TechPortalInfo.CONTENT_TYPE_TEXT_HTML);
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("select * from " + ProductInfo.TABLE_PRODUCT);
			ResultSet rs = ps.executeQuery();
			int i = 0;
			RequestDispatcher rd = req.getRequestDispatcher("ViewPhone.jsp");
			rd.include(req, res);
			pw.println(
					"<div class=\"table table-hover d-flex justify-content-center\">\r\n" + "		<table>\r\n" + "			<tr>\r\n" + "				\r\n"
							+ "				<th>Barcode</th>\r\n" + "				<th>Model</th>\r\n"
							+ "				<th>Brand</th>\r\n" + "				<th>Price</th>\r\n"
							+ "				<th>Quantity</th><br/>\r\n" + "				<th>Total Price</th><br/>\r\n" + "			</tr>");
			double total = 0.0;
			
			Card existingCard = cardDao.getCardForId("1");
			
			String number = null;
			String name = null;
			String expiration = null;
			String cvv = null;
			
			while (rs.next()) {
				int Price = rs.getInt(ProductInfo.COLUMN_PRICE);
				String barcode = rs.getString(ProductInfo.COLUMN_BARCODE);
				String brand = rs.getString(ProductInfo.COLUMN_BRAND);
				String model = rs.getString(ProductInfo.COLUMN_MODEL);
				int Qty = rs.getInt(ProductInfo.COLUMN_QUANTITY);
				i = i + 1;

				String qt = "qty" + Integer.toString(i);
				int quantity = Integer.parseInt(req.getParameter(qt));
				
				number = req.getParameter("number");
				name = req.getParameter("name");
				expiration = req.getParameter("expiration");
				cvv = req.getParameter("cvv");
					
					try {
						String check1 = "checked" + Integer.toString(i);
						String getChecked = req.getParameter(check1);
						if (Qty < quantity) {
							pw.println(
									"</table><div class=\"d-flex justify-content-center text-success display-4\">Please Select the quantity less than Available Phone's Quantity</div>");
							break;
						}
	
						if (getChecked.equals("pay")) {
							pw.println("<tr><td>" + barcode + "</td>");
							pw.println("<td>" + brand + "</td>");
							pw.println("<td>" + model + "</td>");
							pw.println("<td>" + Price + "</td>");
							pw.println("<td>" + quantity + "</td>");
							int amount = Price * quantity;
							total = total + amount;
							pw.println("<td>" + amount + "</td></tr>");
							Qty = Qty - quantity;
							if(existingCard.getName().equals(name) && existingCard.getNumber().equals(number) && existingCard.getExpiration().equals(expiration) && existingCard.getCvv().equals(cvv)) {
								PreparedStatement ps1 = con.prepareStatement("update " + ProductInfo.TABLE_PRODUCT + " set "
										+ ProductInfo.COLUMN_QUANTITY + "=? where " + ProductInfo.COLUMN_BARCODE + "=?");
								ps1.setInt(1, Qty);
								ps1.setString(2, barcode);
								ps1.executeUpdate();
							}
							else {
								pw.println(
										"</table><div class=\"d-flex justify-content-center text-success display-4\">Wrong Credit Card details</div>");
								break;
							}
						}
					} catch (Exception e) {
				}
			}
			if(existingCard.getName().equals(name) && existingCard.getNumber().equals(number) && existingCard.getExpiration().equals(expiration) && existingCard.getCvv().equals(cvv)) {
				pw.println("</table>"
						+ ""
						+ "<br/><div class='d-flex justify-content-center text-success display-4'>Total Paid Amount: " + total + " $" + "</div>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
