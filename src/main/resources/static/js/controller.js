/*
 * controllers
 */

'use strict';

var app = angular.module('myapp.controllers', ['myapp.services']);

app.controller('TodoitemListController', ['$scope', 'TodoitemsFactory', 'TodoitemFactory', '$location',
    function ($scope, TodoitemsFactory, TodoitemFactory, $location) {

        // callback for ng-click 'edit':
        $scope.edit = function (id) {
            alert('edit');
            $location.path('/todoitem-detail/' + id);
        };

        // callback for ng-click 'delete':
        $scope.delete = function (id) {
            alert('delete');
            TodoitemFactory.delete({ id: id });
            $scope.todoitems = TodoitemFactory.query();
        };

        // callback for ng-click 'create':
        $scope.create = function () {
            $location.path('/todoitem-creation');
        };

        $scope.todoitems = TodoitemsFactory.query({ userid: '2' });
    }]
);

app.controller('TodoitemDetailController', ['$scope', 'TodoitemsFactory', 'TodoitemFactory', '$location',
    function ($scope, TodoitemsFactory, TodoitemFactory, $location) {

        // callback for ng-click 'edit':
        $scope.updateItem = function (id) {
            alert('edit');
            $location.path('/todoitem-detail/' + id);
        };

        // callback for ng-click 'create':
        $scope.createItem = function () {
            $location.path('/todoitem-creation');
        };
    }]
);

//        // init load items
//        $http.get('../2/todoitems').
//            success(function(data1) {
//                $scope.todoitems = data1;
//            });

//app.controller('TodoitemListCtrl', ['$scope', 'TodoitemsFactory', 'TodoitemFactory', '$location',
//    function ($scope, TodoitemsFactory, TodoitemFactory, $location) {
//
//        // callback for ng-click 'edit':
//        $scope.editTodoitem = function (id) {
//            $location.path('/todoitem-detail/' + id);
//        };
//
//        // callback for ng-click 'delete':
//        $scope.deleteTodoitem = function (id) {
//            TodoitemFactory.delete({ id: id });
//            $scope.todoitems = TodoitemFactory.query();
//        };
//
//        // callback for ng-click 'create':
//        $scope.createNewTodoitem = function () {
//            $location.path('/todoitem-creation');
//        };
//
//        $scope.todoitems = TodoitemsFactory.query();
//    }]);

//app.controller("MyController", function($scope){
//    $scope.user = {
//        diameter: 200,
//           style: {},
//     };
//});

app.controller('Hello', function ($scope, $http) {
//    $http.get('../todo?id=1').
//        success(function(data) {
//            $scope.todoitem = data;
//        });
});
