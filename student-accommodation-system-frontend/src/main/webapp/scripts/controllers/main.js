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


            var SERVICE_URL = '/student-accommodation-system-webservice';


            $scope.init = function () {
                $scope.isLoggedUser = false;
                $scope.isAddNewProperty = false;
                $scope.user = [];
                $scope.select = {
                    singleSelect: null
                };
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
                    //addLoggedUser(response);
                    $location.path('/');
                    if (!$scope.$$phase)
                        $scope.$apply();

                }, function errorCallback(response) {
                    console.log("Error");
                    $scope.isLoggedUser = false;
                    $scope.user = [];
                });


            };

            $scope.loginUser = function () {
                $http({
                    method: 'GET',
                    url: SERVICE_URL + '/user-service/user-auth',
                    params: {
                        "username": $scope.username,
                        "password": $scope.password
                    }
                }).then(function successCallback(response) {

                    $scope.isLoggedUser = false;
                    console.log("response", response);
                    if (response.data !== null && response.data !== "") {
                        $scope.loginFailed = false;
                        addLoggedUser(response);

                    } else {
                        $scope.loginFailed = true;
                    }

                    console.log("$scope.user", $scope.user);
                }, function errorCallback(response) {
                });


            };

            $scope.addProperty = function () {
                console.log("rane", $scope.select.singleSelect);
                if ($scope.propertyId && $scope.propertyId !== null) {

                    $scope.editProperty();

                } else {
                    $scope.saveProperty();
                }
                $scope.isAddNewProperty = false;
                setTimeout(function () {
                    $scope.loadUser();
                }, 2000);
            };

            $scope.editProperty = function () {
                $http({
                    method: 'POST',
                    url: SERVICE_URL + '/property-service/edit-property',
                    headers: {
                        'Content-Type': 'application/json'
                    },
                    data: {
                        "username": $scope.username,
                        "propertyName": $scope.propertyName,
                        "location": $scope.location,
                        "maximumTenants": $scope.maximumTenants,
                        "propertyType": $scope.propertyType,
                        "amountRent": $scope.amountRent,
                        "status": $scope.select.singleSelect,
                        "id": $scope.propertyId,
                        "fee": 100
                    }
                }).then(function successCallback(response) {
                    console.log("response", response);

                    $scope.isAddNewProperty = false;
                    $scope.loadUser($scope.usertype);
                }, function errorCallback(response) {
                    $scope.isAddNewProperty = false;
                });

            };

            $scope.saveProperty = function () {
                $http({
                    method: 'POST',
                    url: SERVICE_URL + '/property-service/save-property',
                    headers: {
                        'Content-Type': 'application/json'
                    },
                    data: {
                        "username": $scope.username,
                        "propertyName": $scope.propertyName,
                        "location": $scope.location,
                        "maximumTenants": $scope.maximumTenants,
                        "propertyType": $scope.propertyType,
                        "amountRent": $scope.amountRent,
                        "status": $scope.select.singleSelect,
                        "fee": 100
                    }
                }).then(function successCallback(response) {
                    console.log("response", response);

                    $scope.isAddNewProperty = false;
                    $scope.loadUser($scope.usertype);
                }, function errorCallback(response) {
                    $scope.isAddNewProperty = false;
                });

            };

            $scope.loadUser = function (usertype) {
                console.log("loaduser");
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
                    url: SERVICE_URL + '/property-service/read-properties'

                }).then(function successCallback(response) {
                    $scope.items = response.data;
                    console.log("$scope.items", $scope.items);
                }, function errorCallback(response) {

                });
                console.log("user", $scope.user);

            };

            var loadViewForOwner = function () {

                console.log("loadViewForOwner $scope.username", $scope.username);
                $scope.items = [];
                $http({
                    method: 'GET',
                    url: SERVICE_URL + '/property-service/read-properties-by-username',
                    params: {
                        "username": $scope.username,
                        "userType": $scope.usertype
                    }

                }).then(function successCallback(response) {
                    $scope.items = response.data;
                    console.log("$scope.items", $scope.items);
                    if (!$scope.$$phase) {
                        $scope.$apply();
                    }

                    $scope.loadFees();

                    loadOwnerNotification();
                }, function errorCallback(response) {

                });
                console.log("user", $scope.user);

            };

            $scope.loadFees = function () {

                $http({
                    method: 'GET',
                    url: SERVICE_URL + '/property-service/get-fee',
                    params: {
                        "username": $scope.username
                    }

                }).then(function successCallback(response) {
                    $scope.fee = response.data;

                }, function errorCallback(response) {

                });
                console.log("user", $scope.user);

            };

            var loadOwnerNotification = function () {


                $http({
                    method: 'GET',
                    url: SERVICE_URL + '/property-service/get-notification',
                    params: {
                        "username": $scope.username
                    }

                }).then(function successCallback(response) {
                    $scope.requests = response.data;
                    console.log("$scope.requests", $scope.requests);
                }, function errorCallback(response) {

                });
                console.log("user", $scope.user);

            };

            var addLoggedUser = function (response) {

                $scope.email = response.data.email;
                $scope.mobileNumber = response.data.mobileNumber;
                $scope.name = response.data.name;
                $scope.usertype = response.data.userType;
                $scope.username = response.data.username;

                $scope.isLoggedUser = true;
                $scope.loadUser($scope.usertype);
            };

            $scope.requestToView = function (itemId) {

                $http({
                    method: 'POST',
                    url: SERVICE_URL + '/property-service/send-notification',
                    headers: {
                        'Content-Type': 'application/json'
                    },
                    data: {
                        "username": $scope.username,
                        "propertyId": itemId
                    }
                }).then(function successCallback(response) {
                    console.log("response", response);
                    $scope.isAddNewProperty = false;
                    
                    
                }, function errorCallback(response) {
                    $scope.isAddNewProperty = false;
                    
                    
                });

            };

            $scope.addNewProperty = function () {

                $scope.isAddNewProperty = true;
            };

            $scope.logOut = function () {

                $scope.isLoggedUser = false;
                $scope.usertype = "";
                $scope.username = "";
                $scope.name = "";
            };

            $scope.edit = function (item) {

                $scope.propertyName = item.propertyName;
                $scope.location = item.location;
                $scope.maximumTenants = item.maximumTenants;
                $scope.propertyType = item.propertyType;
                $scope.amountRent = item.amountRent;
                $scope.select.singleSelect = item.status;
                $scope.propertyId = item.id;

                $scope.isAddNewProperty = true;
            };

            $scope.init();

        });
