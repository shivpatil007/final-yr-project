package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dbconnection.Dbcon;

@WebServlet("/SponserLoginServlet")
public class SponserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
	    PrintWriter out = response.getWriter();  
	          
	    String email=request.getParameter("email");  
	    System.out.println(email);
	    String password=request.getParameter("password");  
	    System.out.println(password);
	    try {
	    	Connection con=Dbcon.getConnection();
	    	PreparedStatement ps=con.prepareStatement("select * from sponser_reg where email=? and password=?" );
	    	ps.setString(1, email);
	    	ps.setString(2, password);
	    	ResultSet rs=ps.executeQuery();
	    
	    	if(rs.next())
			{
				out.println("<script type=\"text/javascript\">");
				out.println("alert(' Sponser Login Sucessfully..');");
				out.println("location='sponserHome.jsp';");
				out.println("</script>");
			}
			else
			{
				out.println("<script type=\"text/javascript\">");
				out.println("alert('invalid information..');");
				out.println("location='sponserLogin.jsp';");
				out.println("</script>");
			}
	    }
	    catch(Exception e)
	    {
	    	e.printStackTrace();
	    }
	          
	    out.close(); 
	    }  
	

}
