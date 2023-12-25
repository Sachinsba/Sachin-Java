package demo1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/index")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String DB_URL = "jdbc:mysql://localhost:3306/productDetails";
	String DB_USER = "root";
	String DB_PASSWORD = "root123";

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String productId = request.getParameter("product_id"); // Updated parameter name
		// Initialize the database connection and prepared statement
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		// Create a PrintWriter to write the response
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		try {
			// Load the JDBC driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// Establish the database connection
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/productDetails","root","root123");
			
			// Prepare the SQL query to retrieve product details using the product ID
			String sql = "SELECT * FROM products WHERE product_id = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, productId);
			
			// Execute the query and retrieve the result set
			ResultSet rs = stmt.executeQuery();
			
			// Check if the product is found
			if (rs.next()) {
				int productID = rs.getInt("product_id");
				String productName = rs.getString("product_name");
				float productPrice = rs.getFloat("product_cost");
				
				// Display the product details
				pw.println("<h2>Product Details:</h2>");
				pw.println("<p>Product ID: " + productID + "</p>");
				pw.println("<p>Product Name: " + productName + "</p>");
				pw.println("<p>Product Price: " + productPrice + "</p>");
			} 
			else {
				
				// Product not found, display an error message
				pw.println("<h2>Error:</h2>");
				pw.println("<p>Product not found.</p>");
			}
			
			// Close the result set, statement, and connection
			rs.close();
			stmt.close();
			conn.close();
		} 
		catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			// Handle any errors that occur during the database connection or query execution
			pw.println("<h2>Error:</h2>");
			pw.println("<b>Failed to retrieve product details.</b>");
		} 
		finally {
			pw.close();
		}
	}
}


