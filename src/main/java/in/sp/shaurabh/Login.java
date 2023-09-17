package in.sp.shaurabh;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/loinform")
public class Login extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		String myemail=req.getParameter("email1");
		String mypass=req.getParameter("pass1");
		
		PrintWriter out = resp.getWriter();
		
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con	= DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabaseforjspproject","root","");
			PreparedStatement ps = con.prepareStatement("select * from register where email=? and pass=?");
			
			ps.setString(1, myemail);
			ps.setString(2, mypass);
			ResultSet rs =  ps.executeQuery();
			
			if(rs.next())
			{
				RequestDispatcher rD =	req.getRequestDispatcher("/profile.jsp");
				rD.include(req, resp);
			}
			else 
			{
			
				out.print("<h3 style ='color:red'>Email Id and Password did not matched...<h3/>");
				RequestDispatcher rD =	req.getRequestDispatcher("/login");
				rD.include(req, resp);
			}
		
		}
	
		
		catch(Exception e) 
		{
			e.printStackTrace();
			out.print("<h3 style ='color:red'>" +e.getMessage()+"<h3/>");
			RequestDispatcher rD =	req.getRequestDispatcher("/login");
			rD.include(req, resp);
		}

		
	}

}
