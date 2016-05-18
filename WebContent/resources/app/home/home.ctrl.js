(function () {
    'use strict';
    angular
        .module('courseSearch')
        .controller('HomeController', HomeController);

    HomeController.$inject = ['$scope', 'content'];

    function HomeController($scope, content) {
        content.search().then(function(data){
          $scope.semesters = data;
        });
    }
})();