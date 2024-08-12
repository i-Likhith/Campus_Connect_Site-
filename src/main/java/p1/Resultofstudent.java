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

/**
 * Servlet implementation class Resultofstudent
 */
@WebServlet("/Resultofstudent")
public class Resultofstudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Resultofstudent() {
        super();
        // TODO Auto-generated constructor stub
    }

    public static String gradecal(int c)
   	{
   		 String g1="F";
   	        if(c>89)
   	        	g1="A+";
   	        else if(c>79 && c<90)
   	        	g1="A";
   	        else if(c>69 && c<80)
   	        	g1="B+";
   	        else if(c>59 && c<70)
   	        	g1="B";
   	        else if(c>49 && c<60)
   	        	g1="C+";
   	        else if(c>39 && c<50)
   	        	g1="C";
   	        else
   	        	g1="F";
   	        return g1;
   		
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
		int dm=Integer.parseInt(request.getParameter("t1"));;
		String query1="select *from Studentsinfo where id="+dm+"";
		Statement stmt=con.createStatement();

        ResultSet rs=stmt.executeQuery(query1);
        
        response.setContentType("text/html");
        if(rs.next())
       {
        	int c=rs.getInt(3); int v=rs.getInt(4);int b=rs.getInt(5);int n=rs.getInt(6);int m=rs.getInt(7);int l=rs.getInt(8);

        	pw.println("<html><body align='center' bgcolor='pink'>");
        	pw.println("student id is ::"+rs.getInt(1)+"<br>");
        	pw.println("student name is ::"+rs.getString(2));
        	pw.println("<table border='1' align='center'>");
        	pw.println("<tr><th>subject name</th><th>obtained marks</th><th>grade</th></tr>");
        	pw.println("<tr>");
        	pw.println("<td>"+"m1"+"</td>");
        	pw.println("<td>"+rs.getInt(3)+"</td>");
        	pw.println("<td>"+gradecal(c)+"</td>");
        	pw.println("</tr>");
        	pw.println("<tr>");
        	pw.println("<td>"+"m2"+"</td>");
        	pw.println("<td>"+rs.getInt(4)+"</td>");
        	pw.println("<td>"+gradecal(v)+"</td>");
        	pw.println("</tr>");
        	pw.println("<tr>");
        	pw.println("<td>"+"m3"+"</td>");
        	pw.println("<td>"+rs.getInt(5)+"</td>");
        	pw.println("<td>"+gradecal(b)+"</td>");
        	pw.println("</tr>");
        	pw.println("<tr>");
        	pw.println("<td>"+"m4"+"</td>");
        	pw.println("<td>"+rs.getInt(6)+"</td>");
        	pw.println("<td>"+gradecal(n)+"</td>");
        	pw.println("</tr>");
        	pw.println("<tr>");
        	pw.println("<td>"+"m5"+"</td>");
        	pw.println("<td>"+rs.getInt(7)+"</td>");
        	pw.println("<td>"+gradecal(m)+"</td>");
        	pw.println("</tr>");
        	pw.println("<tr>");
        	pw.println("<td>"+"m6"+"</td>");
        	pw.println("<td>"+rs.getInt(8)+"</td>");
        	pw.println("<td>"+gradecal(l)+"</td>");
        	pw.println("</tr>");
        	pw.println("</table");
        	pw.println("</body></html>");
       

        
        int t=(c+v+b+n+m+l)/6;
       String g7=gradecal(t);
       pw.print("Overall grade is::"+g7);
       }
        else
        {
        	pw.println("student record not found");
        }
		

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
