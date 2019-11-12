package user.portal;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import user.portal.*;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;


@WebServlet("/passChange")
public class changePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	

	@Resource(name="jdbc/user_portal")
	private DataSource dataSource;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		
		int id = User.getId();
		String pass = User.getPass();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		
		String oldPass = request.getParameter("currentpass");
		String newPass = request.getParameter("newpass");
		String conPass = request.getParameter("conpass");
		
		if(pass.equals(oldPass)) {
			
			try {
					if(newPass.equals(conPass)) {
					con = dataSource.getConnection();
					String quary = "update user_table set pass=? where id = ?";
					ps = con.prepareStatement(quary);
					ps.setString(1, JavaBase64EncodeDecode.encrypt(newPass));
					ps.setInt(2, id);
					
					ps.executeUpdate();
					
					User.setPass(newPass);
					
					 out.println("<script type='text/javascript'>");
					 out.println("alert('Password Change Successful..');");
					 out.println("location='changePassword.jsp';");
					 out.println("</script>");
					
					
				}else {
					out.println("<script type='text/javascript'>");
					 out.println("alert('New & Confirm Password dose not match..');");
					 out.println("location='changePassword.jsp';");
					 out.println("</script>");
				}	
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else {
			out.println("<script type='text/javascript'>");
			   out.println("alert('Previous Password is Incorrect..!');");
			   out.println("location='changePassword.jsp';");
			   out.println("</script>");
		}
		
	}

}
