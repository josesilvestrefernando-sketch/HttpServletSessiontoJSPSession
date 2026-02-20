<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <%
  String username="";
          // Check if session exists
          HttpSession session2 = request.getSession(false);

          if (session2 == null || session2.getAttribute("user") == null) {
              // If no session or user attribute is not set, redirect to login page
              response.sendRedirect("index.html");
          } else if(session2.getAttribute("user").equals("admin")){
              // Session exists and user is logged in
              username = (String) session2.getAttribute("user");
              }
      %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Dashboard</title>
</head>
<body>
 <h1><%= username %>!</h1>
</body>
</html>