package com.simpli;
import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/searchCrossing")
public class SearchCrossingServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Retrieve the search ID from the request
		int searchId = Integer.parseInt(request.getParameter("searchId"));
		// Implement your logic to search for the crossing by ID and retrieve its
		// details from the database
		RailwayCrossingDAO crossingDAO = new RailwayCrossingDAO();
		RailwayCrossing crossing = crossingDAO.getCrossingById(searchId);
		// Set the search result in the request attribute
		request.setAttribute("crossing", crossing);
		// Redirect to the admin homepage with the search results
		request.getRequestDispatcher("adminHome.jsp").forward(request, response);
	}
}
