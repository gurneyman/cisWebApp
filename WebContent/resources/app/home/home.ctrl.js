(function () {
    'use strict';
    angular
        .module('courseSearch')
        .controller('HomeController', HomeController);

    HomeController.$inject = ['$scope', 'content'];

    function HomeController($scope, content) {
        content.getCourse("4094").then(function(data){
          $scope.semesters = data;
        });
    }
})();