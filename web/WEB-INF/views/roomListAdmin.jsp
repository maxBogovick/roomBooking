<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lenkasava
  Date: 2019-04-08
  Time: 22:01
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>RoomListAdmin</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>

<body class="w3-light-grey">
<div class="w3-container w3-blue-grey w3-opacity w3-right-align">
    <h1>User info!</h1>
</div>

<div class="w3-container w3-padding">
    <div class="w3-card-4">
        <jsp:include page="header.jsp"></jsp:include>
        <jsp:include page="menu.jsp"></jsp:include>
        <div class="w3-container w3-center w3-green">
            <h2>
                <i>Room List Admin</i>
            </h2>
            <table border="1" cellpadding="5" cellspacing="1" >
                <tr>
                    <th>Room Type</th>
                    <th>Capacity</th>
                    <th>Price</th>
                    <th>Quota</th>
                </tr>
                <c:forEach items="${rooms}" var="room" >
                    <tr>
                        <td>${room.roomType}</td>
                        <td>${room.capacity}</td>
                        <td>${room.cost}</td>
                        <td>${room.quota}</td>
                        <td><a href="/api/show_create?id=${room.roomID}">Edit</a></td>
                        <td><a href="/api/delete?id=${room.roomID}">Delete</a></td>
                    </tr>
                    </tr>
                </c:forEach>
            </table>
            <button class="w3-btn w3-hover-light-blue w3-round-large" onclick="location.href='/api/show_create'">Create Room</button>
        </div>
    </div>
</div>
<div class="w3-container w3-grey w3-opacity w3-right-align w3-padding">
    <button class="w3-btn w3-hover-light-blue w3-round-large" onclick="location.href='/api/login'">back to user menu</button>
</div>

<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
