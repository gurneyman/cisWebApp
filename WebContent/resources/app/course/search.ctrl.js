(function() {
    'use strict';
    angular
        .module('courseSearch')
        .controller('SearchController', SearchController);

    SearchController.$inject = ['$scope', '$q', 'content'];

    function SearchController($scope, $q, content) {
        $scope.model = {};
        $scope.findSemesterById = findSemesterById;
        $scope.search = search;
        $q.all([
                content.getSemesters(),
                content.getDepartments(),
                content.getDisciplines()
            ])
            .then(function(responses) {
                for (var i = 0; i < responses.length; i++) {
                    var modelString = 'overwrite';
                    switch (i) {
                        case 0:
                            modelString = "semesters";
                            break;
                        case 1:
                            modelString = "departments";
                            break;
                        case 2:
                            modelString = "disciplines";
                            break;
                    }
                    $scope.model[modelString] = responses[i];
                    $scope.course.semester = findSemesterById('1');
                }
            });

        function search(form) {
            content.search(form).then(function(data){
                $scope.model.sections = data;
            });
        }

        function handler(data, model, name) {
            console.log("Getting: " + name);
            model[name] = data;
        }

        function findSemesterById(form) {
            var semesters = $scope.model.semesters;
            for (var i = 0; i < semesters.length; i++) {
                if (semesters[i].semesterId === form.semesterId) {
                    form.semester = semesters[i];
                    console.log(semesters[i].semesterName);
                    break;
                }
            }
        }

    }


    angular
        .module('courseSearch')
        .filter('sectionFilter', sectionFilter);

    function sectionFilter() {
        return function(items, form) {
            console.log("FILTERING");
            var filtered = [];
            angular.forEach(items, function(item) {
                //var matchSemester = item.
                var matchDiscipline = (form.discipline === 'ALL') ? true : (item.discipline === form.discipline);
                var matchInstructor = (form.instructorLastName === '') ? true : (item.instructorLastName.indexOf(form.instructorLastName.toUpperCase()) === 0);
                var matchCourseNumber = (form.courseNumber === '') ? true : (item.courseNumber.toUpperCase().indexOf(form.courseNumber.toUpperCase()) === 0);
                if (matchDiscipline &&
                    matchInstructor &&
                    matchCourseNumber) {
                    filtered.push(item);
                }
            });
            return filtered;
        }
    }
})();
