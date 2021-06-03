package LibraryPrograms;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.Scanner;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Librarylogin
 */
@WebServlet("/Librarylogin")
public class Librarylogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ResourceBundle bundle=null;
	private Connection conn=null;
	private PreparedStatement pstmnt=null;
	private Scanner scan=null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Librarylogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
final long serialVersionUID = 1L;
       
	
	
  	
	
	
		PrintWriter out=res.getWriter();
		try {
		
		String FirstName=req.getParameter("FirstName");
		
		String LastName=req.getParameter("LastName");
		
		String Email=req.getParameter("Email");
		
		
		String password=req.getParameter("password");
		
		
		
		Scanner scan=new Scanner(System.in);
		

			
		bundle=ResourceBundle.getBundle("com.abc.utilitie.mysqlinfo");
		
		Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(bundle.getString("url"),bundle.getString("user"),bundle.getString("pass"));
	
		
		String sql5="insert into `examplelogin` (`FirstName`,`LastName`,`Email`,`password`)"
				+ "values(?,?,?,?)";
		
		
		pstmnt=conn.prepareStatement(sql5);
		
	
		pstmnt.setString(1, FirstName);
		
		pstmnt.setString(2, LastName);
		
		pstmnt.setString(3, Email);
		
		pstmnt.setString(4, password);
		
		
		int res1=pstmnt.executeUpdate();
		
		System.out.println(res1);
		
		
		
		                   RequestDispatcher disp=req.getRequestDispatcher("Loginsuccssfully.html");
		
		disp.include(req , res);
		
		
		
		
		
		
		
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
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


		if(scan!=null)
		{
			scan.close();
		}
		
		
		if(conn!=null)
		{
			conn.close();
		}
		
		
		if(conn!=null)
		{
			conn.close();
		}
		
		
		
	}
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
