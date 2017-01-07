'use strict';

/**
 * @ngdoc function
 * @name studentAccommodationApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the studentAccommodationApp
 */
angular.module('studentAccommodationApp')
        .controller('UserViewCtrl', function ($rootScope, $scope,$location) {

            $('.message a').click(function () {
                $('form').animate({height: "toggle", opacity: "toggle"}, "slow");
            });

            $scope.registerUser = function(){
            $http({
                method: 'POST',
                url: '/someUrl',
                params:{
                    "name": $scope.name,
                    "username": $scope.username,
                    "password": $scope.password,
                    "emailaddress": $scope.emailaddress,
                    "mobilenumber": $scope.mobilenumber,
                    "usertype": $scope.usertype,
                    "faculty": $scope.faculty,
                    "propertytype": $scope.propertytype,
                    "address": $scope.address,
                    "tenants": $scope.tenants,
                    "amount": $scope.amount
                }
            }).then(function successCallback(response) {
                $rootScope.user = response;
            }, function errorCallback(response) {
            });


            };
            
            $scope.loginUser = function(){
            $http({
                method: 'POST',
                url: '/someUrl',
                params:{
                    "name": $scope.username,
                    "password": $scope.password
                }
            }).then(function successCallback(response) {
             $rootScope.user = response;    
            $location.path( '#/userview' );
            }, function errorCallback(response) {
            });


            };
            
        });
