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
 * Servlet implementation class login_form
 */
@WebServlet("/login_form")
public class login_form extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	String id = null;
	
	String email,password;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		
		email = request.getParameter("email");
		password = request.getParameter("pass");
		String dePass=getDePass(request, response);
		
		if(email.equals("admin@localhost.local") && password.equals("admin")) {
			String command = "All_User";
			request.setAttribute("command", command);
			response.sendRedirect("UserControllerServlet");
		}else if(dePass.equals(password)) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user_portal","root","");
				
				String quary = "select * from user_table where email=?";
				
				ps = con.prepareStatement(quary);
				
				ps.setString(1, email);
				rs = ps.executeQuery();
				
				if(rs.next()) {
					int id = rs.getInt("id");
					String firstName = rs.getString("firstName");
					String lastName = rs.getString("lastName");
					String address = rs.getString("address");
					String phone = rs.getString("phone");
					String emails = rs.getString("email");
					String birthDate = rs.getString("birthDate");
					String pass = JavaBase64EncodeDecode.decrypt(rs.getString("pass"));
					
					User user = new User(id, firstName, lastName, address, phone, emails, birthDate, pass);
					response.sendRedirect("profile.jsp");
					
				}
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			   out.println("<script type='text/javascript'>");
			   out.println("alert('password incorrect');");
			   out.println("location='login.jsp';");
			   out.println("</script>");
		}
		
	}


	private String getDePass(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String orginalPass= null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user_portal","root","");
			
			String quary = "select pass from user_table where email=?";
			
			ps = con.prepareStatement(quary);
			
			ps.setString(1, email);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				String dePass=rs.getString("pass");
				orginalPass= JavaBase64EncodeDecode.decrypt(dePass);
				
			}else {
				 out.println("<script type='text/javascript'>");
				 out.println("alert('Email incorrect');");
				 out.println("location='login.jsp';");
				 out.println("</script>");
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orginalPass;
	}

}
