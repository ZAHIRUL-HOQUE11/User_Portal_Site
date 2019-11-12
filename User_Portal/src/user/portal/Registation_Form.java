package user.portal;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.*;
import java.time.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 * Servlet implementation class Registation_Form
 */
@WebServlet("/register")
public class Registation_Form extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs= null;
	
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
	
		
		
		String firstName,lastName,address,phone,email,birthDate,password;
		
		firstName = request.getParameter("first_name");
		lastName = request.getParameter("last_name");
		address = request.getParameter("adds");
		phone = request.getParameter("phone");
		email = request.getParameter("email");
		birthDate = request.getParameter("birth");
		password = JavaBase64EncodeDecode.encrypt(request.getParameter("pass"));
		
		
		
		String ageArr[] = birthDate.split("-");
		
		
		int years = Integer.parseInt(ageArr[0]);
		int month = Integer.parseInt(ageArr[1]);
		int day = Integer.parseInt(ageArr[2]);
	    int currentAge = calculateAge(day, month, years);
		
	    
	    
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user_portal","root","");
			
			String quary1 = "select * from user_table where email=?";
			ps=con.prepareStatement(quary1);
			ps.setString(1, email);
			rs=ps.executeQuery();
			if(rs.next()) {
				out.println("<script type='text/javascript'>");
				 out.println("alert('Your Email Address Already Exsits..!!');");
				 out.println("location='registration.html';");
				 out.println("</script>");
			}else {
				String quary = "INSERT INTO `user_table`(`firstName`,`lastName`,`address`,`phone`,`email`,`birthDate`,`pass`,age) VALUES(?,?,?,?,?,?,?,?)";
				
				ps = con.prepareStatement(quary);
				
				ps.setString(1, firstName);
				ps.setString(2, lastName);
				ps.setString(3, address);
				ps.setString(4, phone);
				ps.setString(5, email);
				ps.setString(6, birthDate);
				ps.setString(7, password);
				ps.setInt(8, currentAge);
				
			    ps.executeUpdate();
				
				RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
				rd.forward(request, response);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	int calculateAge(int day, int month, int year) {

        LocalDate birth = LocalDate.of(year, month, day);
        LocalDate now = LocalDate.now();
        Period diffYear = Period.between(birth, now);
        return diffYear.getYears();

    }

}
