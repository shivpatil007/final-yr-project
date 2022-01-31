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

/**
 * Servlet implementation class RecipientLoginServlet
 */
@WebServlet("/RecipientLoginServlet")
public class RecipientLoginServlet extends HttpServlet {
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
	    	PreparedStatement ps=con.prepareStatement("select * from recipient_reg where email=? and password=?" );
	    	ps.setString(1, email);
	    	ps.setString(2, password);
	    	ResultSet rs=ps.executeQuery();
	    
	    	if(rs.next())
			{
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Recipient Login Sucessfully..');");
				out.println("location='recipientHome.jsp';");
				out.println("</script>");
			}
			else
			{
				out.println("<script type=\"text/javascript\">");
				out.println("alert('invalid information..');");
				out.println("location='recipientLogin.jsp';");
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
