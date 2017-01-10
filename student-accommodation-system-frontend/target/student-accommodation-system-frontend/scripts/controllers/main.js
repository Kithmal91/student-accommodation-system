'use strict';

/**
 * @ngdoc function
 * @name studentAccommodationApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the studentAccommodationApp
 */
angular.module('studentAccommodationApp')
        .controller('MainCtrl', function ($rootScope, $scope, $location, $http) {

            $scope.isLoggedUser = false;
            $rootScope.user = [];
            var SERVICE_URL = '/student-accommodation-system-webservice';

            $('.message a').click(function () {
                $('form').animate({height: "toggle", opacity: "toggle"}, "slow");
            });

            $scope.registerUser = function () {
                console.log($rootScope);
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
                    addLoggedUser(response);

                    console.log("$rootScope.user", $rootScope.user);
                    
                }, function errorCallback(response) {
                    console.log("Error");
                    $scope.isLoggedUser = false;
                     $rootScope.user = [];
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
                    $rootScope.user = [];
                    $scope.isLoggedUser = false;
                    console.log("response",response);
                    if(response.data !== null){
                        console.log("$rootScope.user in", $rootScope.user);
                        addLoggedUser(response);
                        
                    }
                    
                    console.log("$rootScope.user", $rootScope.user);
                }, function errorCallback(response) {
                });


            };

            $scope.addProperty = function () {

                $http({
                    method: 'POST',
                    url: SERVICE_URL,
                    params: {
                        "propertytype": $scope.propertytype,
                        "address": $scope.address,
                        "tenants": $scope.tenants,
                        "amount": $scope.amount
                    }
                }).then(function successCallback(response) {

                }, function errorCallback(response) {

                });
            };

            var loadUser = function (usertype) {
                  console.log("in loadUser",usertype);
                if (usertype === "student") {
                    console.log("call loadViewForStudent",usertype);
                    loadViewForStudent();
                } else {
                    loadViewForOwner();
                }

                $scope.isLoggedUser = true;

            };

            var loadViewForStudent = function () {
                console.log("in loadViewForStudent");
                $http({
                    method: 'GET',
                    url: SERVICE_URL+'/property-service/read-properties'
                    
                }).then(function successCallback(response) {
                    console.log("in loadViewForStudent response",response);
                    $rootScope.items = response.data;
                    console.log("$scope.items",$scope.items);
                    console.log("$location",$location);
                    
                    $location.path('userview');
                    if (!$rootScope.$$phase) $rootScope.$apply();
                }, function errorCallback(response) {

                });

                
            };

            var loadViewForOwner = function () {


                $http({
                    method: 'GET',
                    url: SERVICE_URL,
                    params: {
                        "usertype": $scope.user.usertype,
                        "userId": $scope.user.userId
                    }
                }).then(function successCallback(response) {
                    $scope.items = response;
                }, function errorCallback(response) {

                });

                $location.path('#/userview');
            };
            
            var addLoggedUser = function(response){
                
                $rootScope.user.email = response.data.email;
                    $rootScope.user.mobileNumber = response.data.mobileNumber;
                    $rootScope.user.name = response.data.name;
                    $rootScope.user.userType = response.data.userType;
                    $rootScope.user.username = response.data.username;
                    console.log("call loadUser",$rootScope.user.userType);
                    loadUser($rootScope.user.userType);
            };

        });
