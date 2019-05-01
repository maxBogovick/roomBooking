<%--
  Created by IntelliJ IDEA.
  User: lenkasava
  Date: 2019-04-27
  Time: 19:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new room</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>

<body class="w3-light-grey">
<div class="w3-container w3-blue-grey w3-opacity w3-right-align">
    <h1>Room Reservation!</h1>
</div>

<div class="w3-container w3-padding">
    <div class="w3-card-4">
        <div class="w3-container w3-center w3-green">
            <h2>Create new room</h2>
        </div>
        <form method="post" action="/api/create_room" class="w3-selection w3-light-grey w3-padding">
            <input type="hidden" name="roomId" value="${room.roomID}"/>
            <input type="hidden" name="orderId" value="${room.orderId}"/>
            <label>Type:
                <input type="text" required name="type" maxlength="50" value="${room.roomType}" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br />
            </label>
            <label>Capacity:
                <input type="number" required maxlength="3" value="${room.capacity}" name="capacity" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br />
            </label>
            <label>Cost:
                <input type="number" required name="cost" value="${room.cost}" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br />
            </label>
            <label>Quota:
                <input type="number" required name="quota" value="${room.quota}" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br />
            </label>
            <button type="submit" class="w3-btn w3-green w3-round-large w3-margin-bottom">Submit</button>
        </form>
    </div>
</div>

<div class="w3-container w3-grey w3-opacity w3-right-align w3-padding">
    <button class="w3-btn w3-round-large" onclick="location.href='/api/admin_home_list'">Back admin room list</button>
</div>
</body>
</html>
