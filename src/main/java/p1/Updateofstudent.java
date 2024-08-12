package p1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Updateofstudent
 */
@WebServlet("/Updateofstudent")
public class Updateofstudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Updateofstudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw=response.getWriter();
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver is loaded");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/collegemanagement2","root","7890");
		System.out.println("Connection is established");
		Statement stmt=con.createStatement();
		String w=request.getParameter("m");
		int marks=Integer.parseInt(request.getParameter("t2"));
		int di=Integer.parseInt(request.getParameter("t1"));
	    String f="update Studentsinfo set "+w+"="+marks+" where id="+di+"";
	stmt.executeUpdate(f);
pw.println("updation success");	
/*if(r>1)pw.println("registration success");
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
