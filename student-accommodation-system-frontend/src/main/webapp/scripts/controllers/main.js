'use strict';

/**
 * @ngdoc function
 * @name studentAccommodationApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the studentAccommodationApp
 */
angular.module('studentAccommodationApp')
        .controller('MainCtrl', function ( $scope, $location, $http) {
            
            
            var SERVICE_URL = '/student-accommodation-system-webservice';

            
            $scope.init = function(){
                $scope.isLoggedUser = false;
                $scope.isAddNewProperty = false;
                $scope.user = [];
            };

            $scope.registerUser = function () {
                console.log($scope);
                console.log($scope.formdata);
                $http({
                    method: 'POST',
                    url: SERVICE_URL + '/user-service/save-user',
                    headers: {
                        'Content-Type': 'application/json'
                    },
                    data: {"name": $scope.name,
                        "username": $scope.username,
                        "password": $scope.password,
                        "email": $scope.emailaddress,
                        "mobileNumber": $scope.mobilenumber,
                        "userType": $scope.usertype
                    }
                }).then(function successCallback(response) {
                    
                    $scope.isLoggedUser = false;
                    addLoggedUser(response);
                    
                }, function errorCallback(response) {
                    console.log("Error");
                    $scope.isLoggedUser = false;
                     $scope.user = [];
                });


            };

            $scope.loginUser = function () {
                $http({
                    method: 'GET',
                    url: SERVICE_URL +'/user-service/user-auth',
                    params: {
                        "username": $scope.username,
                        "password": $scope.password
                    }
                }).then(function successCallback(response) {
                    
                    $scope.isLoggedUser = false;
                    console.log("response",response);
                    if(response.data !== null){
                        addLoggedUser(response);
                        
                    }
                    
                    console.log("$scope.user", $scope.user);
                }, function errorCallback(response) {
                });


            };

            $scope.addProperty = function () {


                $http({
                    method: 'POST',
                    url: SERVICE_URL+'/property-service/save-property',
                    headers: {
                        'Content-Type': 'application/json'
                    },
                    data: {
                        "propertyName": $scope.propertyName,
                        "location": $scope.location,
                        "maximumTenants": $scope.maximumTenants,
                        "propertyType": $scope.propertyType,
                        "amountRent": $scope.amountRent,
                        "fee":100
                    }
                }).then(function successCallback(response) {
                    $scope.isAddNewProperty = false;
                }, function errorCallback(response) {

                });
            };

            var loadUser = function (usertype) {
                if (usertype === "student") {
                    loadViewForStudent();
                } else {
                    loadViewForOwner();
                    loadOwnerNotification();
                }

                $scope.isLoggedUser = true;

            };

            var loadViewForStudent = function () {
                console.log("in loadViewForStudent");
                $http({
                    method: 'GET',
                    url: SERVICE_URL+'/property-service/read-properties'
                    
                }).then(function successCallback(response) {
                    $scope.items = response.data;
                    console.log("$scope.items",$scope.items);
                }, function errorCallback(response) {

                });
                    console.log("user",$scope.user);
                
            };

            var loadViewForOwner = function () {


                $http({
                    method: 'GET',
                    url: SERVICE_URL+'/property-service/read-properties-by-username',
                    params: {
                        "username": $scope.username,
                        "userType": $scope.usertype
                    }
                    
                }).then(function successCallback(response) {
                    $scope.items = response.data;
                    console.log("$scope.items",$scope.items);
                }, function errorCallback(response) {

                });
                    console.log("user",$scope.user);

            };
            
            var loadOwnerNotification = function () {


                $http({
                    method: 'GET',
                    url: SERVICE_URL+'/property-service/read-properties-by-username',
                    params: {
                        "username": $scope.username,
                        "userType": $scope.usertype
                    }
                    
                }).then(function successCallback(response) {
                    $scope.requests = response.data;
                    console.log("$scope.requests",$scope.requests);
                }, function errorCallback(response) {

                });
                    console.log("user",$scope.user);

            };
            
            var addLoggedUser = function(response){
                
                $scope.email = response.data.email;
                    $scope.mobileNumber = response.data.mobileNumber;
                    $scope.name = response.data.name;
                    $scope.usertype = response.data.userType;
                    $scope.username = response.data.username;
                    
                    $scope.isLoggedUser = true;
                    loadUser($scope.usertype);
            };
            
            $scope.requestToView = function(itemId){
                
                alert("request "+itemId + "username"+ $scope.username);
            };
            
             $scope.addNewProperty = function(){
                
                $scope.isAddNewProperty = true;
            };
            
            $scope.logOut = function(){
                
                $scope.isLoggedUser = false;
                $scope.usertype = "";
                    $scope.username = "";
                    $scope.name = "";
            };
            
            $scope.init();

        });
