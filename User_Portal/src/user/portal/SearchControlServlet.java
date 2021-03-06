package user.portal;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;


@WebServlet("/SearchControlServlet")
public class SearchControlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	String searchName;
	
	private UserDbUtil userDbUtil;
	
	@Resource(name="jdbc/user_portal")
	private DataSource dataSource;
	
	public void init() throws ServletException{
		super.init();
		
		try {
			userDbUtil = new UserDbUtil(dataSource);
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		searchName = request.getParameter("search");
		
		try {
			searchUser(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	private void searchUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		List<AllUser> user = userDbUtil.getSearchUser(searchName);
		request.setAttribute("search_user_list", user);
		
		request.setAttribute("adminLog", "search");
		
		RequestDispatcher dis = request.getRequestDispatcher("/adminPanel.jsp");
		dis.forward(request, response);
		
	}


}
