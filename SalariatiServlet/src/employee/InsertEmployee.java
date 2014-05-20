package employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

/**
 * @author Georgiana Danila
 *
 * 
 */
public class InsertEmployee extends HttpServlet {
	Connection conn = null;
	Statement stmt = null;
	
	public void insert(HttpServletRequest request) {
		try {
			// Create a database "Connection" object
			Class.forName("com.mysql.jdbc.Driver");
		      // setup the connection with the DB.
		      conn = DriverManager
		          .getConnection("jdbc:mysql://localhost/mydb", "root","root");

			// Create a "Statement" object inside the "Connection"
			stmt = conn.createStatement();

			// Execute a SQL INSERT
			Integer id = Integer.valueOf(request.getParameter("id"));
			Float salariu = Float.valueOf(request.getParameter("salary"));
			Integer departament = Integer.valueOf(request.getParameter("department"));
			String sqlStr = "INSERT INTO salariati VALUES ("
				+id+",'"+request.getParameter("name")+"',"+salariu+",'"+request.getParameter("birthday")+"',"+departament+")";

			System.out.println(sqlStr);
			stmt.executeUpdate(sqlStr); // Send the query to the server

		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				// Step 5: Close the Statement and Connection
				if (stmt != null) stmt.close();
				if (conn != null) conn.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}
}


