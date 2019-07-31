<%--
  Created by IntelliJ IDEA.
  User: Nifras
  Date: 5/8/2017
  Time: 11:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <%@ page isELIgnored="false" %>
    <title>Searching result </title>
    <%--<link rel='stylesheet' href='<c:url value="/resources/css/style.css" />' type='text/css' media='all' />--%>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha/js/bootstrap.min.js"></script>
</head>
<body style="background-color: rgba(177, 255, 236, 0.92)">
<h2 style="font-family: Georgia" align="center" >Search Result</h2>

<%--<p>ALL, ${datafeedsForm}</p>--%>

<%--<table>
    <tr>
        <th>Points</th>
        &lt;%&ndash;<th></th>&ndash;%&gt;
    </tr>
    <c:forEach items="${datafeedsForm}" var="theme" varStatus="status">
        <tr>
           &lt;%&ndash; <td>${theme.id}</td>&ndash;%&gt;
            <td>${theme}</td>
        </tr>
    </c:forEach>


</table>--%>

<div>
<table class="table table-inverse">
    <thead class="span3">
    <tr style="background-color: #0059b3">

        <th>Beaches and Ratings</th>
    </tr>
    </thead>
    <tbody>

<c:forEach items="${datafeedsForm}" var="theme" varStatus="status">

    <tr style="background-color: #4da6ff">


        <td>${theme}</td></td>

    </tr>
</c:forEach>
    </tbody>
</table>
    </div>

<%--<p><h3>Recommended for You</h3></p>--%>

<div style="background-color: rgba(177, 255, 236, 0.92)" align="center">
    <p><h3>Recommended for You</h3></p>
    <h2>${sugession}</h2>
    <img src="resources/images/${sugession}.jpg" class="img-circle" alt="Cinque Terre" width="304" height="236">
</div>



<%--<c:forEach items="${datafeedsForm}" var="theme" varStatus="status">
    <tr>

        <td>${theme}</td>
    </tr>
</c:forEach>--%>



</body>
</html>
