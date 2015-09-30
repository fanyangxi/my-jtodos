'use strict';

angular.module('myapp', ['myapp.services', 'myapp.controllers']).
    config(['$routeProvider', function ($routeProvider) {
        $routeProvider.when('/todoitem-list', {templateUrl: 'partials/todoitem-list.html', controller: 'TodoitemListCtrl'});
        $routeProvider.when('/todoitem-detail/:id', {templateUrl: 'partials/todoitem-detail.html', controller: 'TodoitemDetailCtrl'});
        $routeProvider.when('/todoitem-creation', {templateUrl: 'partials/todoitem-creation.html', controller: 'TodoitemCreationCtrl'});
        $routeProvider.otherwise({redirectTo: '/todoitem-list'});
    }]);