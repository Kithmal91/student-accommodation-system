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
                    url: SERVICE_URL + '/user-service/save',
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
                    $rootScope.user.email = response.data.email;
                    $rootScope.user.mobileNumber = response.data.mobileNumber;
                    $rootScope.user.name = response.data.name;
                    $rootScope.user.userType = response.data.userType;
                    $rootScope.user.username = response.data.username;

                    console.log("$rootScope.user", $rootScope.user);
                    //loadUser($rootScope.user.usertype);
                }, function errorCallback(response) {
                    console.log("Error");
                });


            };

            $scope.loginUser = function () {
                $http({
                    method: 'POST',
                    url: SERVICE_URL,
                    params: {
                        "name": $scope.username,
                        "password": $scope.password
                    }
                }).then(function successCallback(response) {
                    $rootScope.user = response;
                    loadUser($rootScope.user.usertype);
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
                if (usertype === "student") {
                    loadViewForStudent();
                } else {
                    loadViewForOwner();
                }

                $scope.isLoggedUser = true;

            };

            var loadViewForStudent = function () {

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

        });
