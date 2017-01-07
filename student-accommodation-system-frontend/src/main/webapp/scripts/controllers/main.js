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
            var SERVICE_URL = '/localhost:8080/Services';

            $('.message a').click(function () {
                $('form').animate({height: "toggle", opacity: "toggle"}, "slow");
            });

            $scope.registerUser = function () {
                $http({
                    method: 'POST',
                    url: SERVICE_URL,
                    params: {
                        "name": $scope.name,
                        "username": $scope.username,
                        "password": $scope.password,
                        "emailaddress": $scope.emailaddress,
                        "mobilenumber": $scope.mobilenumber,
                        "usertype": $scope.usertype
                    }
                }).then(function successCallback(response) {
                    $rootScope.user = response;
                    loadUser($rootScope.user.usertype);
                }, function errorCallback(response) {
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
