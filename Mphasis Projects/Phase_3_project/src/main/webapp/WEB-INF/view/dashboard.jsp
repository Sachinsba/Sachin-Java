<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dashboard</title>
</head>
<body>

<div align="right" >
       <% String userid = (String) session.getAttribute("userid");%>
       <p align="left">User Name:<span style="color:#FF0066"> <%= userid %></span><p>
       <a href="<c:url value='/admin/logout' />">logout</a>
</div>

                  <h1 align="center">VACCINATION CENTER | WELCOME</h1>

<hr><br>
<center>
    <div class="link-container">             
                <a href="<c:url value='/admin/citizen/viewCitizen' />?userid=${userid}">Citizens</a>&nbsp&nbsp
                <a href="<c:url value='/admin/vaccination/viewCenterList' />?userid=${userid}">Vaccination Centers</a>      
     </div><br>
</center>
</body>
</html>