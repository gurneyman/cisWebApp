(function () {
    'use strict';
    angular
        .module('courseSearch')
        .controller('ResultsController', ResultsController);

    ResultsController.$inject = ['$scope', 'content'];

    function ResultsController($scope, content) {
        content.getDisciplines().then(function(data){
          $scope.semesters = data;
        });
    }
})();