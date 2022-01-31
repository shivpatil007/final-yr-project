package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dbconnection.Dbcon;

/**
 * Servlet implementation class OrganizationRegistrationServlet
 */
@WebServlet("/OrganizationRegistrationServlet")
public class OrganizationRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");

		PrintWriter out = response.getWriter();
		
		String name=request.getParameter("name");
		System.out.println(name);
	
		String mobile=request.getParameter("mobile");
		System.out.println(mobile);
		
		String email=request.getParameter("email");
		System.out.println(email);
	
		String password=request.getParameter("password");
		System.out.println(password);
		
try {
		Connection con=Dbcon.getConnection();
			String query="insert into organization_reg(name, mobile, email, password) values (?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, name);
			ps.setString(2, mobile);
			ps.setString(3, email);
			ps.setString(4, password);

			int i=ps.executeUpdate();
			if(i>0)
			{
				out.println("<script type=\"text/javascript\">");
				out.println("alert('register sucessfully..');");
				out.println("location='orgnizationLogin.jsp';");
				out.println("</script>");
			}
			else
			{
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Not register..');");
				out.println("location='organizationRegistration.jsp';");
				out.println("</script>");
			}
			} catch (Exception e) {
			e.printStackTrace();
			}
		}

}


