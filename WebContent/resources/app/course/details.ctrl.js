(function () {
    'use strict';
    angular
        .module('courseSearch')
        .controller('DetailsController', DetailsController);

    DetailsController.$inject = ['$scope', '$stateParams', '$sce', 'content'];

    function DetailsController($scope, $stateParams, $sce, content) {
        // content.getDisciplines().then(function(data){
        //   $scope.semesters = data;
        // });
        $scope.params = $stateParams;

        content.getCourseCommentsByCode($stateParams.courseCode).then(function(data){
            $scope.comments = data;
        });

        // Need to get course with disc and number
        content.getCourseById($stateParams.discipline, $stateParams.courseNumber).then(function(data){
            $scope.course = data;
            $scope.description = $sce.trustAsHtml(data.description);
        });

        // Need to get Course section with code
        content.getCourseSectionBySection($stateParams.discipline, $stateParams.courseNumber, $stateParams.sectionCode).then(function(data){
            $scope.section = data;
        });

    }
})();