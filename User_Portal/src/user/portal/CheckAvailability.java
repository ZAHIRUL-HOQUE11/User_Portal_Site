package user.portal;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/CheckAvailability")
public class CheckAvailability extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Resource(name="jdbc/user_portal")
    private DataSource dataSource;
	
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String userEmail = request.getParameter("email");
		
		String quary = "select * from user_table where email=?";
		
		try {
			con=dataSource.getConnection();
			ps = con.prepareStatement(quary);
			ps.setString(1, userEmail);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				out.print("<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
				out.print("This Email Already Exists..!!");
			}else {
				response.setContentType("text/html");
				out.print("");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
