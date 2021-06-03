
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@ page import="java.io.PrintWriter"%>
<%@ page import="java.sql.Connection"%>
<%@ page import=" java.sql.DriverManager"%>
<%@ page import="java.sql.ResultSet"%>
<%@ page import="java.sql.SQLException"%>
<%@ page import="java.sql.Statement"%>
<%@ page import="java.util.ResourceBundle"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<%!String url = "jdbc:mysql://localhost:3306/banking";
	String user = "root";
	String pass = "chandu";%>

	<%!public int add() {
			return 10 + 20;
		}%>

	<%
	Class.forName("com.mysql.jdbc.Driver");
	Connection conn = DriverManager.getConnection(url, user, pass);
	System.out.println("connection is established ");
	String sql = "select * from bank";
	Statement stmnt = conn.createStatement();
	ResultSet res = stmnt.executeQuery(sql);
	while (res.next()) {

	System.out.println(res.getInt(1) + "" + res.getString(2) + "" + res.getInt(3));
	 
	}
	%>

	<h1>

		the sum is
		<%
	add();
	%>>
	</h1>



</body>
</html>


