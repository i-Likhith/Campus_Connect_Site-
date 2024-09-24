package p1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Registerofstudent")
public class Registerofstudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Registerofstudent() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		int id = Integer.parseInt(request.getParameter("t1"));
		String name = request.getParameter("t2");
		int m1 = Integer.parseInt(request.getParameter("t3"));
		int m2 = Integer.parseInt(request.getParameter("t4"));
		int m3 = Integer.parseInt(request.getParameter("t5"));
		int m4 = Integer.parseInt(request.getParameter("t6"));
		int m5 = Integer.parseInt(request.getParameter("t7"));
		int m6 = Integer.parseInt(request.getParameter("t8"));
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver is loaded");
				
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/CampusConnectPortal","username","password");
			System.out.println("Connection is established");
				
			Statement stmt = con.createStatement();
			int val = stmt.executeUpdate("insert into studentsinfo values("+id+",'"+name+"',"+m1+","+m2+","+m3+","+m4+","+m5+","+m6+")");
			
			pw.println("registration success");	
			/*if(r>0)
	  			pw.println("registration success");
			else 
				pw.println("registration unsuccess");*/
			con.close();
			
		}
		catch(ClassNotFoundException e)
		{
			pw.println("class not found");
		}
		catch(Exception e)
		{
			pw.println("connection error");
		}
	}
}
