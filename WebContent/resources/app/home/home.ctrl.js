(function () {
    'use strict';
    angular
        .module('courseSearch')
        .controller('HomeController', HomeController);

    HomeController.$inject = ['$scope', 'content'];

    function HomeController($scope, content) {
        content.getSemesters().then(function(data){
          $scope.semesters = data;
        });
    }
})();