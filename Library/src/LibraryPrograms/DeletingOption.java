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
 * Servlet implementation class DeletingOption
 */
@WebServlet("/DeletingOption")
public class DeletingOption extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	

	
private ResourceBundle bundle =null;
private PreparedStatement pstmnt;
private Connection conn=null;
private Scanner scan=null;
	
	
	
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletingOption() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	
	
		PrintWriter out=res.getWriter();

		
		Scanner scan=new Scanner(System.in);
		String ID=req.getParameter("ID");
		
		try {		
		bundle =ResourceBundle.getBundle("com.abc.utilitie.mysqlinfo");
		
		Class.forName("com.mysql.jdbc.Driver");

	conn=DriverManager.getConnection(bundle.getString("url"),bundle.getString("user"),bundle.getString("pass"));
			
	     //Delete from library where ID='788';
			
			String sql2="Delete from library where ID=?";
			
			pstmnt=conn.prepareStatement(sql2);

			
			pstmnt.setString(1, ID);
		
			
			int i=pstmnt.executeUpdate();
			
			System.out.println(i);
			
			
	RequestDispatcher disp=req.getRequestDispatcher("SuccesfuDeleted.html");
			
			disp.include(req,res);
			
			
			
		}catch(SQLException | ClassNotFoundException e) {
			
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
		
		if(pstmnt!=null)
		{
			pstmnt.close();
		}
		
		if(conn!=null)
		{
			conn.close();
		}
		
		
		
	}

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
