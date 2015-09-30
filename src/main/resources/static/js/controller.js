/*
 * controllers
 */

'use strict';

var app = angular.module('myapp.controllers', ['myapp.services']);

app.controller('TodoitemsController', ['$scope', 'TodoitemsFactory', 'TodoitemFactory', '$location', '$window', '$timeout',
    function ($scope, TodoitemsFactory, TodoitemFactory, $location, $window, $timeout) {

        // callback for ng-click 'create':
        $scope.create = function () {
            //TodoitemFactory.create(***);

            if(!$scope.currentTodoitem.userid)
            {
                alert("Please enter userid");
                return;
            }

            if(!$scope.currentTodoitem.name)
            {
                alert("Please enter todoitem name");
                return;
            }

            $scope.currentTodoitem.userid = '2';
            TodoitemsFactory.create($scope.currentTodoitem);

            // $location.path('/todoitem-creation');
            // todo: using timeout here may not be a good idea
            $timeout(function() {
                $scope.todoitems = TodoitemsFactory.query({ userid: '2' });
            }, 500);
        };

        // callback for ng-click 'editing':
        $scope.editing = function (id, todoitem) {
            // load item data to data-form
            // $location.path('/todoitem-detail/' + id);
            // $scope.todoitems = TodoitemsFactory.query({ userid: '2' });
            $scope.currentTodoitem = todoitem;
        };

        // callback for ng-click 'update':
        $scope.update = function (id) {
            // alert('update');
            // $location.path('/todoitem-detail/' + id);
            // TodoitemFactory.update(todoitem);
            TodoitemFactory.update($scope.currentTodoitem);
            $window.location.href = $window.location.href;
        };

        // callback for ng-click 'delete':
        $scope.delete = function (id) {
            var retVal = confirm("Do you want to delete item: (" + id + ")?");
            if (retVal == true) {
                // $scope.todoitems = TodoitemsFactory.query({ userid: '2' });
                // $window.location.href = $window.location.href;
                TodoitemFactory.delete({ userid: '2', id: id });
                $timeout(function() {
                    $scope.todoitems = TodoitemsFactory.query({ userid: '2' });
                }, 500);
                return true;
            } else {
                return false;
            }
        };

        $scope.todoitems = TodoitemsFactory.query({ userid: '2' });
    }]
);

app.controller('TodoitemDetailController', ['$scope', 'TodoitemsFactory', 'TodoitemFactory', '$location',
    function ($scope, TodoitemsFactory, TodoitemFactory, $location) {

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
