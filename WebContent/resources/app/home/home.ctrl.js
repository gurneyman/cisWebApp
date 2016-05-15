(function () {
    'use strict';
    angular
        .module('courseSearch')
        .controller('HomeController', HomeController);

    HomeController.$inject = ['$scope', 'content'];

    function HomeController($scope, content) {
        content.getInstructor("0727").then(function(data){
          $scope.semesters = data;
        });
    }
})();