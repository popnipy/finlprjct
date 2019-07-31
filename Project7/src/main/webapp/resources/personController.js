/**
 * Created by Nifras on 5/30/2017.
 */

/*(function () {
    'use strict';*/
var app = angular.module('myApp',[]);
/*app.controller('myCtrl',function ($scope,$http) {

    $scope.myFunction = function () {


        $http.get('/http://localhost:9090/insert').then(function (response) {
            $scope.allPersons = response.data;
        },  function myError(response) {
        $scope.myWelcome = response.statusText;
            //handle error
        })
    };


})
})();*/


app.controller('myCtrl', function($scope, $location) {
    $scope.myFunction = function() {
        $location.url('http://localhost:9090/insert');
    };
})