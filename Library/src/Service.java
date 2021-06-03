

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.Scanner;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Service
 */
@WebServlet("/Service")
public class Service extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ResourceBundle bundle=null;
	private Connection conn=null;
	private PreparedStatement pstmnt;
    private Scanner scan=null;   
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Service() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

	PrintWriter pw=res.getWriter();
	
	try {
	
	Scanner scan=new Scanner(System.in);
	Class.forName("com.mysql.cj.jdbc.Driver");
	
	bundle=ResourceBundle.getBundle("com.abc.utilities.mysql");
	
	  conn=DriverManager.getConnection(bundle.getString("url"),
			  bundle.getString("user"),
			  bundle.getString("pass"));
	
	System.out.println("Connection is established !!!!!");
	
String sql="insert into advance (FirstName,LastName,Email,Password) values(?,?,?,?)";
	
	pstmnt=conn.prepareStatement(sql);
	
	String FirstName=req.getParameter("FirstName");
	String LastName=req.getParameter("LastName");
	String Email=req.getParameter("Email");
	String Password=req.getParameter("Password");
	
	pstmnt.setString(1,FirstName);
	pstmnt.setString(2, LastName);
	pstmnt.setString(3, Email);
	pstmnt.setString(4, Password);
	
	
int abc=	pstmnt.executeUpdate();
	
System.out.println(abc);


	}catch(SQLException | ClassNotFoundException e)
	{
		e.printStackTrace();
		
	}
	finally {
		
		try {
			close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	}
	private void close() throws SQLException {

		
		if(scan!=null) {
			scan.close();
		}
		
		if(conn!=null) {
			conn.close();
		}
		
		if(pstmnt!=null) {
			pstmnt.close();
		}
	}

}
