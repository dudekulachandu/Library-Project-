package LibraryPrograms;

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
 * Servlet implementation class Registerr
 */
@WebServlet("/Registerr")
public class Registerr extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	private ResourceBundle bundle=null;
	private Connection conn=null;
	private PreparedStatement pstmnt=null;
	private Scanner scan=null;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registerr() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	
	
PrintWriter out=res.getWriter();
		
		
		String StudentName=req.getParameter("StudentName");
		
		String RollNo=req.getParameter("RollNo");
		
		String Year=req.getParameter("Year");
		
		
		String Branch=req.getParameter("Branch");
		
		
		
		Scanner scan=new Scanner(System.in);
		
		try {
			
		bundle=ResourceBundle.getBundle("com.abc.utilitie.mysqlinfo");
		
		Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(bundle.getString("url"),bundle.getString("user"),bundle.getString("pass"));
	
		
		String sql5="insert into `Registerform` (`StudentName`,`RollNo`,`Year`,`Branch`)"
				+ "values(?,?,?,?)";
		
		
		pstmnt=conn.prepareStatement(sql5);
		
	
		pstmnt.setString(1, StudentName);
		
		pstmnt.setString(2, RollNo);
		
		pstmnt.setString(3, Year);
		
		pstmnt.setString(4, Branch);
		
		
		int res1=pstmnt.executeUpdate();
		
		System.out.println(res1);
		
		
		
		RequestDispatcher disp=req.getRequestDispatcher("RegisterSuccfully.html");
		
		disp.include(req , res);
		
		
		
		
		
		
		
		} catch (ClassNotFoundException | SQLException e) {
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
