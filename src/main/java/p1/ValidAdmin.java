package p1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.mysql.*;
/**
 * Servlet implementation class ValidAdmin
 */
@WebServlet("/ValidAdmin")
public class ValidAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter pw=response.getWriter();
		String name=request.getParameter("t1");
		String pwd=request.getParameter("t2");
		//pw.println(name);
		//pw.println(pwd);

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			pw.println("driver loaded");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/collegemanagement2","root","7890");
			pw.println("Connection established");
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from admin where username='"+name+"' AND password='"+pwd+"'");
			if(rs.next())
			{
				response.sendRedirect("adminindex.html");
			}
			else
			{
				pw.println("invalid Admin credentials");
			}		
		}

		catch(Exception e)
		{
			pw.println("error");
		}

	}
}