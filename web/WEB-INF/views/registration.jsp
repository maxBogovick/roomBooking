<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: lenkasava
  Date: 2019-04-04
  Time: 12:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new user</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>

<body class="w3-light-grey">
<div class="w3-container w3-blue-grey w3-opacity w3-right-align">
    <h1>room.booking</h1>
</div>

<div class="w3-container w3-padding">
    <div class="w3-card-4">
        <div class="w3-container w3-center w3-green">
            <h2>registration.title</h2>
        </div>
        <form method="post" action="/api/registration" class="w3-selection w3-light-grey w3-padding">

            <%--<div>--%>
                <%--<c:if test="${error.equals(true)}">--%>
                    <%--<div class="w3-red"><fmt:message key="registration.exception"/></div>--%>
                <%--</c:if>--%>
                <%--<c:if test="${successful.equals(true)}">--%>
                    <%--<div class="w3-blue"><fmt:message key="button.ok"/></div>--%>
                <%--</c:if>--%>
            <%--</div>--%>
            <label>Name:
                <input type="text" required name="name" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br />
            </label>
            <label>Email:
                <input type="text" required name="email" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br />
            </label>
            <label>Password:
                <input type="password" required name="pass" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br />
            </label>
            <button type="submit" class="w3-btn w3-green w3-round-large w3-margin-bottom">Submit</button>
        </form>
    </div>
</div>

<div class="w3-container w3-grey w3-opacity w3-right-align w3-padding">
    <button class="w3-btn w3-round-large" onclick="location.href='../..'">Back to main</button>
</div>
</body>
</html>

