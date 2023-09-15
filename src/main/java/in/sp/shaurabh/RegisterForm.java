package in.sp.shaurabh;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/regform")
public class RegisterForm extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String myname = req.getParameter("name1");
		String myemail = req.getParameter("email1");
		String mypass = req.getParameter("pass1");
		String mygender = req.getParameter("gender1");
		String mycity = req.getParameter("city1");

		PrintWriter out = resp.getWriter();
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabaseforjspproject", "root","");

			PreparedStatement preparedStatement = connection.prepareStatement("insert into register values(?,?,?,?,?)");
			preparedStatement.setString(1, myname);
			preparedStatement.setString(2, myemail);
			preparedStatement.setString(3, mypass);
			preparedStatement.setString(4, mygender);
			preparedStatement.setString(5, mycity);

			int i = preparedStatement.executeUpdate();
			if (i > 0) {
				resp.setContentType("text/html");
				out.print("<h3>User Register seccessfully<h3/>");
				RequestDispatcher rd = req.getRequestDispatcher("/register.jsp");
				rd.include(req, resp);
			} else {

				resp.setContentType("text/html");
				out.print("<h3>User not Register deu to some erroe<h3/>");
				RequestDispatcher rd = req.getRequestDispatcher("/register.jsp");
				rd.include(req, resp);
			}
		} catch (Exception e) {
			e.printStackTrace();

			resp.setContentType("text/html");
			out.print("<h3>Thank you <h3/>");
			RequestDispatcher rd = req.getRequestDispatcher("/register.jsp");
			rd.include(req, resp);
		}

	}

}
