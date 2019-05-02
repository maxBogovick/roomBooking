<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="language" value="${not empty sessionScope.language ? sessionScope.language : pageContext.request.locale}"
       scope="session"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="text"/>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>room.booking</title>
  <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>

<body class="w3-light-grey">
<div class="w3-container w3-blue-grey w3-opacity w3-right-align">
  <h1>room.booking</h1>
</div>

<div class="w3-container w3-center">
  <div class="w3-bar w3-padding-large w3-padding-24">
    <button class="w3-btn w3-hover-light-blue w3-round-large" onclick="location.href='/api/show_registration'">Registration</button>
    <button class="w3-btn w3-hover-green w3-round-large" onclick="location.href='/api/login'">Login</button>
    <div>
      <a href="${pageContext.request.contextPath}/views/language//?language=UA">
        <fmt:message key="ua"/>
      </a>
      <a href="${pageContext.request.contextPath}/views/language//?language=EN">
        <fmt:message key="en"/>
      </a>
    </div>
  </div>
</div>


</body>
</html>