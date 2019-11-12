package user.portal;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class UserDbUtil {

	private DataSource dataSource;
	int id;
	String email,pass;
	
	public UserDbUtil(DataSource theDataSource) {
		dataSource = theDataSource;
	}
	
	public List<AllUser> getUser() throws Exception{
		
		List<AllUser> user = new ArrayList<>();
		
		Connection con = null;
		Statement sm = null;
		ResultSet rs = null;
		
		
		try {
			
			con = dataSource.getConnection();
			
			String quary = "select * from user_table order by firstName";
			
			sm = con.createStatement();
			
			rs = sm.executeQuery(quary);
			
			while(rs.next()) {
				
				int id = rs.getInt("id");
				String firstName = rs.getString("firstName");
				String lastName = rs.getString("lastName");
				String address = rs.getString("address");
				String phone = rs.getString("phone");
				String email = rs.getString("email");
				String birthDate = rs.getString("birthDate");
				String pass = rs.getString("pass");
				int age = rs.getInt("age");
				
				
				AllUser theUser = new AllUser(id, firstName, lastName, address, phone, email, birthDate, pass,age);
				user.add(theUser);
			}
			
			return user;
		}finally {
			close(con,sm,rs);
		}
		
		
	}
	
	
public List<AllUser> getSearchUser(String name) throws Exception{
		
		List<AllUser> user = new ArrayList<>();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String userName = name;
		
		if(name == null) {
			
			System.out.print("Value is null");
		}else {
			
		}
		
		try {
			
			con = dataSource.getConnection();
			
			String quary = "SELECT * FROM user_table WHERE firstName='"+name+"' OR lastName='"+name+"' OR email='"+name+"' OR phone='"+name+"'";
			
			ps = con.prepareStatement(quary);
			
			rs = ps.executeQuery(quary);
			
			while(rs.next()) {
				
				int id = rs.getInt("id");
				String firstName = rs.getString("firstName");
				String lastName = rs.getString("lastName");
				String address = rs.getString("address");
				String phone = rs.getString("phone");
				String email = rs.getString("email");
				String birthDate = rs.getString("birthDate");
				String pass = rs.getString("pass");
				int age = rs.getInt("age");
				
				
				AllUser theUser = new AllUser(id, firstName, lastName, address, phone, email, birthDate, pass,age);
				user.add(theUser);
			}
		
			
			return user;
		}finally {
			close(con,ps,rs);
		}
		
		
		
	}


	private void close(Connection con, Statement sm, ResultSet rs) {
		
		try {
			
			if(rs != null) {
				rs.close();
			}
			
			if(sm != null) {
				sm.close();
			}
			
			if(con != null) {
				con.close();
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	

	
	
	
}
