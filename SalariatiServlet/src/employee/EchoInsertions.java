package employee;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Georgiana Danila
 *
 * 
 */
public class EchoInsertions extends HttpServlet{

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Set the MIME type for the response message
		response.setContentType("text/html");
		// Get a output writer to write the response message into the network socket
		PrintWriter out = response.getWriter();
		try {
			out.println("<!DOCTYPE html>");
			out.println("<html><head>");
			out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
			out.println("<title>Echo Servlet</title></head>");
			out.println("<body><h2>You have enter</h2>");

			// Retrieve the value of the query parameter "id" (from text field)
			String idEmployee = request.getParameter("id");
			// Get null if the parameter is missing from query string.
			// Get empty string or string of white spaces if user did not fill in
			if (idEmployee == null
					|| (idEmployee = htmlFilter(idEmployee.trim())).length() == 0) {
				throw new Exception("Must introduce employee ID");
			} else {
				out.println("<p>Id: " + idEmployee + "</p>");
			}

			// Retrieve the value of the query parameter "name" (from text field)
			String name = request.getParameter("name");
			// Get null if the parameter is missing from query string.
			// Get empty string or string of white spaces if user did not fill in
			if (name == null
					|| (name = htmlFilter(name.trim())).length() == 0) {
				out.println("<p>Name: MISSING</p>");
			} else {
				out.println("<p>Name: " + name + "</p>");
			}

			// Retrieve the value of the query parameter "birthday" (from text field)
			String birthday = request.getParameter("birthday");
			// Get null if the parameter is missing from query string.
			// Get empty string or string of white spaces if user did not fill in
			if (birthday == null
					|| (birthday = htmlFilter(birthday.trim())).length() == 0) {
				out.println("<p>Birthday: MISSING</p>");
			} else {
				out.println("<p>Birthday: " + birthday + "</p>");
			}

			// Retrieve the value of the query parameter "salary" (from text field)
			String salary = request.getParameter("salary");
			// Get null if the parameter is missing from query string.
			// Get empty string or string of white spaces if user did not fill in
			if (salary == null
					|| (salary = htmlFilter(salary.trim())).length() == 0) {
				out.println("<p>Salary: MISSING</p>");
			} else {
				out.println("<p>Salary: " + salary + "</p>");
			}

			// Retrieve the value of the query parameter "department" (from pull-down menu)
			String dept = request.getParameter("department");
			if (dept == null) {
				out.println("<p>Department: MISSING</p>");
			} else if (dept.equals("10")) {
				out.println("<p>Department: 10</p>");
			} else if (dept.equals("20")) {
				out.println("<p>Department: 20</p>");
			} else if (dept.equals("30")) {
				out.println("<p>Department: 30</p>");
			} else if (dept.equals("40")) {
				out.println("<p>Department: 40</p>");
			} else if (dept.equals("50")) {
				out.println("<p>Department: 50</p>");
			}
			
			InsertEmployee insertion = new InsertEmployee();
			insertion.insert(request);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();  // Always close the output writer
		}

	}

	// Filter the string for special HTML characters to prevent
	// command injection attack
	private static String htmlFilter(String message) {
		if (message == null) return null;
		int len = message.length();
		StringBuffer result = new StringBuffer(len + 20);
		char aChar;

		for (int i = 0; i < len; ++i) {
			aChar = message.charAt(i);
			switch (aChar) {
			case '<': result.append("&lt;"); break;
			case '>': result.append("&gt;"); break;
			case '&': result.append("&amp;"); break;
			case '"': result.append("&quot;"); break;
			default: result.append(aChar);
			}
		}
		return (result.toString());
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		doGet(request, response);  // call doGet()
	}
}