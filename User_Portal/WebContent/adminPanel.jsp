<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*, user.portal.*,java.time.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Admin Panel</title>
    <link rel="stylesheet" href="CSS/styleSecond.css">
    <script src="https://kit.fontawesome.com/e7516258f9.js" crossorigin="anonymous"></script>
</head>


	<%
	
	String val = request.getAttribute("adminLog").toString();
	
	List<AllUser> theUser;
	
	if(val.equals("adminlog")){
		theUser = (List<AllUser>) request.getAttribute("user_list");
	}else{
		theUser = (List<AllUser>) request.getAttribute("search_user_list");
	}
	%>

<body>
    <ul>
      <li class="dropdown">
      <a href="javascript:void(0)"><i class="fas fa-sort-down"></i></a>
      <div class="container">
         <a href="login.jsp">Log Out</a>
      </div>
      </li>
      <li><h3>Admin</h3></li>
    </ul>
    <div class="left">
        <a href="UserControllerServlet">User List</a>
    </div>
    <div class="right">
        <div class="user_list">
            <h2>User List</h2>
            <form class="example" action="SearchControlServlet" style="margin:auto;max-width:300px">
              <input type="text" placeholder="Search.." name="search" required>
              <button type="submit" name="serachButton"><i class="fa fa-search"></i></button>
            </form>
        </div>
        <div class="table_block">
            <table>
            <tr>
                <th>Name</th>
                <th>Age</th>
                <th>Email</th>
                <th>Phone</th>
            </tr>
            
            
            <%for(AllUser tempUser : theUser){ %>
            
            	<tr>
	            	<td style="text-align: center;"><%=tempUser.getFirstName()%>&nbsp<%=tempUser.getLastName()%></td>
	            	<td style="text-align: center;"><%=tempUser.getAge() %></td>
	            	<td style="text-align: center;"><%=tempUser.getEmail()%></td>
	            	<td style="text-align: center;"><%=tempUser.getPhone()%></td>
            	</tr>
            <%} %>
        </table>
        </div>
    </div>
    <div class="clear"></div>
    <div class="footer"></div>
</body>
</html>