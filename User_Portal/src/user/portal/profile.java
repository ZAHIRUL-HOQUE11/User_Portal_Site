package user.portal;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class profile
 */
@WebServlet("/profile")
public class profile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Connection con = null;
	ResultSet rs = null;
	PreparedStatement ps = null;
	
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		//String id = (String) request.getAttribute("id");
		//String email = request.getParameter("email");
		//String password = request.getParameter("pass");
		
		RequestDispatcher rd = request.getRequestDispatcher("profile.jsp");
		rd.forward(request, response);
		//response.sendRedirect("profile.jsp");
		/**
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user_portal","root","");
			
			String quary = "select * from user_table where id=?";
			
			ps = con.prepareStatement(quary);
			
			ps.setString(1, email);
			ps.setString(2, password);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				//`firstName```````````
				/*String firsName = rs.getString("firstName");
				String lastName = rs.getString("lastName");
				String address = rs.getString("address");
				String phone = rs.getString("phone");
				String emails = rs.getString("email");
				String birthDate = rs.getString("birthDate");*/
				
				/*request.setAttribute("firsName", rs.getString("firstName"));
				request.setAttribute("lastName", rs.getString("lastName"));
				request.setAttribute("address", rs.getString("address"));
				request.setAttribute("phone", rs.getString("phone"));
				request.setAttribute("emails", rs.getString("email"));
				request.setAttribute("birthDate", rs.getString("birthDate"));
				
				
				RequestDispatcher rd = request.getRequestDispatcher("profile.jsp");
				rd.forward(request, response);
				//response.sendRedirect("profile.jsp");
				
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
		
	}

}
