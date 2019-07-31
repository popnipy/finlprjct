<%--
  Created by IntelliJ IDEA.
  User: Nifras
  Date: 5/8/2017
  Time: 11:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <%-- <link rel='stylesheet' href='<%= org.webjars.AssetLocator.getWebJarPath("css/bootstrap.min.css") %>'>
     <link rel='stylesheet' href='<%= org.webjars.AssetLocator.getWebJarPath("css/bootstrap-theme.min.css") %>'>
     <script type='text/javascript' src='<%= org.webjars.AssetLocator.getWebJarPath("jquery.min.js") %>'></script>
     <script type='text/javascript' src='<%= org.webjars.AssetLocator.getWebJarPath("js/bootstrap.min.js") %>'></script>--%>
    <%-- <meta name="viewport" content="width=device-width, initial-scale=1">--%>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
    <script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>

    <%@ page isELIgnored="false" %>
    <title>Data retrieve from here</title>
    <link rel='stylesheet' href='<c:url value="/resources/css/style.css" />' type='text/css' media='all' />
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <%-- <script src="personController.js"></script>--%>
    <%-- <script src="C:\Users\Nifras\IdeaProjects\Project7\src\main\webapp\resources\personController.js"></script>
     <script src="content/js/jquery.min.js"></script>
     <script src="content/js/bootstrap.min.js"></script>--%>
        <meta charset="utf-8">
</head>
<body>
<div class="topnav" id="myTopnav">
    <ul class="nav nav-tabs">
    <a href="#Archi">Architecture </a>
    <a href="#Beaches">Beaches</a>
    <a href="#Histo">Historical</a>
    <a href="#Nature">Nature</a>
    <a href="javascript:void(0);" class="icon" onclick="myFunction()">&#9776;</a>
</ul></div>


<p>Welcome, ${name4}</p>
<h2>Data Execution From Here</h2>


<div class="container">
    <h3>Pills With Dropdown Menu</h3>
    <ul class="nav nav-pills nav-stacked">
        <li class="active"><a href="#">Home</a></li>
        <li class="dropdown">
            <a class="dropdown-toggle" data-toggle="dropdown" href="#">Architecture <span class="caret"></span></a>
            <ul class="dropdown-menu">


                <li><a href="#">Archi1</a> <a href="#" class="w3-button w3-green">+</a>

                </li>
                <li><a href="#">Archi2</a><a href="#" class="w3-button w3-green">+</a>

                </li>

            </ul>
        </li>

        <li class="dropdown">
            <a class="dropdown-toggle" data-toggle="dropdown" href="#">Beaches <span class="caret"></span></a>
            <ul class="dropdown-menu">
                <li><a href="#">GalleFace</a><a href="#" class="w3-button w3-green">+</a>

                </li>
                <li><a href="#">Bentota</a><a href="/runbentota" class="w3-button w3-green">+</a>

                </li>

            </ul>
        </li>
        <li class="dropdown">
            <a class="dropdown-toggle" data-toggle="dropdown" href="#">Historical <span class="caret"></span></a>
            <ul class="dropdown-menu">
                <li><a href="#">Historical1</a><a href="#" class="w3-button w3-green">+</a>

                </li>
                <li><a href="#">Historical2</a><a href="#" class="w3-button w3-green">+</a>

                </li>

            </ul>
        </li>

        <li class="dropdown">
            <a class="dropdown-toggle" data-toggle="dropdown" href="#">Nature <span class="caret"></span></a>
            <ul class="dropdown-menu">
                <li><a href="#">Nature1</a><a href="#" class="w3-button w3-green">+</a>

                </li>
                <li><a href="#">Nature2</a><a href="#" class="w3-button w3-green">+</a>

                </li>

            </ul>
        </li>
    </ul>
</div>







    </div>

<style>
    body {margin:0;}
    .topnav {
        background-color: #333;
        overflow: hidden;
    }

    /* Style the links inside the navigation bar */
    .topnav a {
        float: left;
        display: block;
        color: #f2f2f2;
        text-align: center;
        padding: 14px 16px;
        text-decoration: none;
        font-size: 17px;
    }

    /* Change the color of links on hover */
    .topnav a:hover {
        background-color: #ddd;
        color: black;
    }

    /* Hide the link that should open and close the topnav on small screens */
    .topnav .icon {
        display: none;
    }

</style>








<script src="personController.js"></script>
<script src="C:\Users\Nifras\IdeaProjects\Project7\src\main\webapp\WEB-INF\views\personController.js"></script>

<%--<button type="button" class="btn btn-primary"><i class="glyphicon glyphicon-search"></i></button>
<button type="button" class="btn btn-primary"><i class="glyphicon glyphicon-search"></i></button>--%>

</body>
</html>
