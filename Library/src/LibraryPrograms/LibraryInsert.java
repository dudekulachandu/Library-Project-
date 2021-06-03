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
 * Servlet implementation class LibraryInsert
 */
@WebServlet("/LibraryInsert")
public class LibraryInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	private ResourceBundle bundle=null;
	private Connection conn=null;
	private PreparedStatement pstmnt=null;
	private Scanner scan=null;

	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LibraryInsert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	
	
		PrintWriter out=res.getWriter();

		String ID=req.getParameter("ID");
		String BookName=req.getParameter("BookName");
		String AuthorName=req.getParameter("AuthorName");
		String  Price=req.getParameter("Price");
		
		
					
		
		try {
			
			Scanner scan=new Scanner(System.in);
		bundle=ResourceBundle.getBundle("com.abc.utilitie.mysqlinfo");
		Class.forName("com.mysql.jdbc.Driver");
		conn=DriverManager.getConnection(bundle.getString("url"),bundle.getString("user"),bundle.getString("pass"));
		
		 
		
		
		String sql="insert into library    (`ID`,`BookName`,`AuthorName`,`Price`)"
				+ "values(?,?,?,?)";
		
		
		pstmnt=conn.prepareStatement(sql);
	
	   
		pstmnt.setString(1, ID);
		
		pstmnt.setString(2, BookName);
		
		pstmnt.setString(3, AuthorName);
		
		pstmnt.setString(4, Price);
		
		
		int i=pstmnt.executeUpdate();
		
		
		System.out.println(i);
		
		
		
		
RequestDispatcher disp=req.getRequestDispatcher("insertedSuccessfull.html");
		
		
		disp.include(req , res);
		
	//out.println("alert('successfully cplted')");
		
		
		
		
		
		
		
		
		
		
		
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
		// TODO Auto-generated method stub
		
		
		if(scan!=null)
		{
			scan.close();
		}
		
		
		if(conn!=null)
		{
			conn.close();
		}
		
		if(pstmnt!=null)
		{
			pstmnt.close();
		}

		
		
	}
		
}
	
	
	
	
	
	
	
