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

@WebServlet("/ValidAdmin")
public class ValidAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public ValidAdmin() {	 
		super();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		String admin_username = request.getParameter("t1");
		String admin_password = request.getParameter("t2");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			pw.println("driver loaded");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/CampusConnectPortal","username","password");
			pw.println("Connection established");
			
			Statement st = con.createStatement();
			String query = "select * from admin where username='"+admin_username+"' AND password='"+admin_password+"'";
			ResultSet rs = st.executeQuery(query);
			
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
