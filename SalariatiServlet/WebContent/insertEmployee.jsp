<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert Employee Form</title>
</head>
<body>
<h2>Employee Input Form</h2>
<form method="get" action="echo">
  <fieldset>
    Employee Id: <input type="text" name="id" /><br /><br />
    Employee Name: <input type="text" name="name" /><br /><br />
    Birthday (yyyy-mm-dd): <input type="text" name="birthday"><br /><br />
    Salary: <input type="text" name="salary"><br /><br />
    Department: <select name = "department">
      <option value="10">10</option>
      <option value="20">20</option>
      <option value="30">30</option>
      <option value="40">40</option>
      <option value="50">50</option>
    </select><br /><br />
  </fieldset><br /><br />
 
  <input type="hidden" name="secret" value="888" />
  <input type="submit" value="SEND" />
  <input type="reset" value="CLEAR" />
</form>
</body>
</html>