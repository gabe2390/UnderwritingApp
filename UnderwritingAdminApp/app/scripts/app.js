'use strict';

/**
 * @ngdoc overview
 * @name underwritingAdminAppApp
 * @description
 * # underwritingAdminAppApp
 *
 * Main module of the application.
 */
angular
  .module('underwritingAdminAppApp', [
    'ngAnimate',
    'ngCookies',
    'ngResource',
    'ngRoute',
    'ngSanitize',
    'ngTouch',
    'Underwriting.Admin'
  ])
  .config(function ($routeProvider) {
    $routeProvider
      .when('/', {
        templateUrl: 'features/admin/views/admin.html',
        controller: 'AdminControl',
        controllerAs: 'admin'
      })
      .otherwise({
        redirectTo: '/'
      });
  });
