package com.simpli;
import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/adminHomePage")
public class AdminHomePageServlet extends HttpServlet {
	private RailwayCrossingDAO crossingDAO;
	public void init() {
		crossingDAO = new RailwayCrossingDAO();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Fetch all railway crossing details from the database
		List<RailwayCrossing> crossings = crossingDAO.getAllCrossings();
		// Pass the crossing details to the JSP page
		request.setAttribute("crossings", crossings);
		request.getRequestDispatcher("adminHome.jsp").forward(request, 
				response);
	}
}
