package demo1;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	
	private static final String VALID_USERNAME = "sachin";
	private static final String VALID_PASSWORD = "sachin456";

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		PrintWriter pw = response.getWriter();
		
		if (username.equals(VALID_USERNAME) && password.equals(VALID_PASSWORD)) {
			
			pw.write("<b>Login successful</b> "+username);
		} 
		else {
			
			pw.write("<b>Login failed, check your credentials..!!</b>");
		}
	}
}
