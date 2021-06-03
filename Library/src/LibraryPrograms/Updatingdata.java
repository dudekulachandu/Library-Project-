package LibraryPrograms;

import java.io.IOException;
import java.io.PrintWriter;
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
 * Servlet implementation class Updatingdata
 */
@WebServlet("/Updatingdata")
public class Updatingdata extends HttpServlet {
	private static final long serialVersionUID = 1L;
    

	private ResourceBundle bundle;
	private java.sql.Connection conn=null;
	private PreparedStatement pstmnt=null;
	private Scanner  scan=null;

	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Updatingdata() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	
	
		   
			PrintWriter out=res.getWriter();
				
			String BookName=req.getParameter("BookName");
			
			String AuthorName=req.getParameter("AuthorName");

			String Price=req.getParameter("Price");

			
			String ID=req.getParameter("ID");
				
				
			
			
			
				try {
			
			bundle=ResourceBundle.getBundle("com.abc.utilitie.mysqlinfo");
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(bundle.getString("url"),bundle.getString("user"),bundle.getString("pass"));
		
		
			
			String sq3="update  library set BookName=?,AuthorName=? ,Price=? where ID=?";
			  
//			String sq3="update  library"
//			+ "set BookName='?'"
//			+ ",AuthorName='?'"
//			+ ", Price=?"
//			+ "where ID='?'";
	//	
	//	
//			update  library set BookName='chand', 
//					 AuthorName='Ramanji' ,Price='1234'
//					 where ID='5111';
//							
			
			
			

			pstmnt=conn.prepareStatement(sq3);
	       
			pstmnt.setString(1, BookName);
			
			pstmnt.setString(2, AuthorName);
			
			
			pstmnt.setString(3, Price);
			
			pstmnt.setString(4, ID);
			
		
			
		
			
			
			int i=pstmnt.executeUpdate();
			
			
			System.out.println(i);


			
			
			
			
			
			
	RequestDispatcher disp=req.getRequestDispatcher("updatedsuccessfully.html");
			
			
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
			// TODO Auto-generated method stub
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
