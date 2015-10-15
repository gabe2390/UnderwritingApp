'use strict';

/**
 * @ngdoc overview
 * @name underwritingClientAppApp
 * @description
 * # underwritingClientAppApp
 *
 * Main module of the application.
 */
angular
  .module('underwritingClientAppApp', [
    'ngAnimate',
    'ngCookies',
    'ngResource',
    'ngRoute',
    'ngSanitize',
    'ngTouch',
    'underwritingClientAppApp.controllers',
    //'underwritingClientAppApp.services'
  ])
  .config(function ($routeProvider) {
    $routeProvider
      .when('/', {
        templateUrl: 'features/application/views/loan-application.html',
        controller: 'applicationCtrl',
      })
      .when('/about', {
        templateUrl: 'features/application/views/loan-application.html',
        controller: 'AboutCtrl',
        controllerAs: 'about'
      })
      .otherwise({
        redirectTo: 'features/application/views/loan-application.html'
      });
  });
