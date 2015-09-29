var app = angular.module('myApp',['ui.grid', 'ngResource']);

//app.controller("MyController", function($scope){
//    $scope.user = {
//        diameter: 200,
//           style: {},
//     };
//});

app.controller('loadTodoitems', ['$scope', '$http', function ($scope, $http) {
    $http.get('../user-todos/2').
        success(function(data1) {
            $scope.todos = data1;
        });
}]);


app.controller('Hello', function ($scope, $http) {
//    $http.get('../todo?id=1').
//        success(function(data) {
//            $scope.todoitem = data;
//        });
});
