'use strict';

/**
 * @ngdoc overview
 * @name studentAccommodationApp
 * @description
 * # studentAccommodationApp
 *
 * Main module of the application.
 */
angular
  .module('studentAccommodationApp', [
    'ngAnimate',
    'ngCookies',
    'ngResource',
    'ngRoute',
    'ngSanitize',
    'ngTouch'
  ])
  .config(function ($routeProvider) {
    $routeProvider
      .when('/', {
        templateUrl: 'views/main.html',
        controller: 'MainCtrl',
        controllerAs: 'main'
      })
      .when('/about', {
        templateUrl: 'views/about.html',
        controller: 'AboutCtrl',
        controllerAs: 'about'
      })
      .when("/red", {
        templateUrl : "views/red.html"
    })
      .otherwise({
        redirectTo: '/'
      });
  });
