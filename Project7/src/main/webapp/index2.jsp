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
    <link rel='stylesheet' href='<%= org.webjars.AssetLocator.getWebJarPath("css/bootstrap.min.css") %>'>
    <link rel='stylesheet' href='<%= org.webjars.AssetLocator.getWebJarPath("css/bootstrap-theme.min.css") %>'>
    <script type='text/javascript' src='<%= org.webjars.AssetLocator.getWebJarPath("jquery.min.js") %>'></script>
    <script type='text/javascript' src='<%= org.webjars.AssetLocator.getWebJarPath("js/bootstrap.min.js") %>'></script>

    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <%@ page isELIgnored="false" %>
    <title>Spring 4 MVC Hello World Example with Maven Eclipse</title>
    <link rel='stylesheet' href='<c:url value="/resources/css/style.css" />' type='text/css' media='all' />
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
   <%-- <script src="personController.js"></script>--%>
    <script src="C:\Users\Nifras\IdeaProjects\Project7\src\main\webapp\resources\personController.js"></script>

</head>
<body>
<h2>Select the OPtions</h2>

<p> ${name}</p>
<div ng-app="myApp" ng-controller="myCtrl">
   <%-- <button class="w3-btn w3-green w3-ripple" ng-click="myFunction()">Click</button>--%>

    {{ firstName + " " + lastName }}

    <a href="/insert" class="w3-button w3-ripple w3-black">
        Click-Insert
    </a>
       <a href="/retrieve" class="w3-button w3-ripple w3-black">
           Click-Retrieves
       </a>
       <a href="/execute" class="w3-button w3-ripple w3-black">
           Click-Execute
       </a>
</div>
<div ng-view></div>

<script>

    var app = angular.module("myApp", []);

    app.controller("myCtrl", function($scope) {
        $scope.firstName = "John";
        $scope.lastName = "Doe";
    });

</script>

<script>
app.controller('myCtrl', function($scope, $location) {
$scope.myFunction = function() {
$location.url('/insert');
};
})
app.config(['$locationProvider', function($locationProvider) {
    $locationProvider.hashPrefix('');
    $locationProvider.hashPrefix('');
}]);


/*app.directive( 'goClick', function ( $location ) {
    return function ( scope, element, attrs ) {
        var path;

        attrs.$observe( 'goClick', function (val) {
            path = val;
        });

        element.bind( 'click', function () {
            scope.$apply( function () {
                $location.path( path );
            });
        });
    };
});*/


</script>



<script src="personController.js"></script>
<script src="C:\Users\Nifras\IdeaProjects\Project7\src\main\webapp\WEB-INF\views\personController.js"></script>

<%--<button type="button" class="btn btn-primary"><i class="glyphicon glyphicon-search"></i></button>
<button type="button" class="btn btn-primary"><i class="glyphicon glyphicon-search"></i></button>--%>

</body>
</html>
