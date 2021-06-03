package LibraryPrograms;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.Scanner;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SelectReading
 */
@WebServlet("/SelectReading")
public class SelectReading extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	private static ResourceBundle bundle=null;
	private static Connection conn=null;
	private static Statement stmnt=null;
	private static ResultSet res1=null;
	private static Scanner scan=null;

	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectReading() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	

		
		PrintWriter out=res.getWriter();
		
	try {
			
			Scanner scan=new Scanner(System.in);
		bundle=ResourceBundle.getBundle("com.abc.utilitie.mysqlinfo");
		Class.forName("com.jdbc.mysql.Driver");
		conn=DriverManager.getConnection(bundle.getString("url"),bundle.getString("user"),bundle.getString("pass"));
		
	String sqll="select * from library";
	
	
	
	stmnt=conn.createStatement();
	
	
	  res1=stmnt.executeQuery(sqll);
	  out.print(String.format("%-10s%-10s%-10s%-10s \n","ID","BookName","AuthorName","price") );
		
	while(res1.next())
	{
		
		
out.print(String.format("%-10s%-10s%-10s%-10s", res1.getString(1)+""+res1.getString(2)+""+res1.getString(3)+""+res1.getString(4)  ));
	
		
	}
	
	
RequestDispatcher disp=req.getRequestDispatcher("ReadSuccessfully.html");
	
	
	disp.include(req ,res);
	
	
	
	
	}catch(SQLException | ClassNotFoundException e)
	{
		e.printStackTrace();
	}finally {
		
		try {
			close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	}

	private static void close() throws SQLException {
		// TODO Auto-generated method stub
		
		
		
		if(scan!=null)
		{
			scan.close();
		}
		
		if(stmnt!=null)
		{
			stmnt.close();
		}
		
		
		if(conn!=null)
		{
			conn.close();
		}
		
		
		if(res1!=null)
		{
		res1.close();
		}
		
		
		
		
		
		
	}
	
	
	
}	
	
	
	
	
