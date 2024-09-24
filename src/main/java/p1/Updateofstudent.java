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

@WebServlet("/Updateofstudent")
public class Updateofstudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Updateofstudent() {
		super();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		int pin = Integer.parseInt(request.getParameter("t1"));
		String sub_name = request.getParameter("m");
		int marks = Integer.parseInt(request.getParameter("t2"));
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver is loaded");
				
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/CampusConnectPortal", "username","password");
			System.out.println("Connection is established");
				
			Statement stmt = con.createStatement();
			
			String query = "update Studentsinfo set "+sub_name+"="+marks+" where id="+pin+"";
			stmt.executeUpdate(query);
			pw.println("updation success");	
				
			/*if(r>1)
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
