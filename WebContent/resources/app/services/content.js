(function() {
    angular
        .module('courseSearch')
        .service('content', Content);

    Content.$inject = ['$http', '$q'];

    function Content($http, $q) {
        var content = {
            data: {},
            getCourseById: getCourseById,
            getCourses: getCourses,
            getCourseCommentsByCode: getCourseCommentsByCode,
            getCourseComments: getCourseComments,
            getCourseSectionBySection: getCourseSectionBySection,
            getCourseSectionByIndex: getCourseSectionByIndex,
            getCourseSections: getCourseSections,
            getDepartments: getDepartments,
            getDepartmentById: getDepartmentById,
            getDepartmentByName: getDepartmentByName,
            getDisciplines: getDisciplines,
            getDisciplineByAbbreviation: getDisciplineByAbbreviation,
            getInstructorByCourseCode: getInstructorByCourseCode,
            getInstructors: getInstructors,
            getSemesters: getSemesters,
            searchTest: searchTest,
            search: search
        };
        return content;

        function getCourses() {
            return getData("courses", "getCourses");
        }

        function getCourseById(discipline, number) {
            return getData("course/" + discipline + "/" + number, "getCourseById:" + discipline + "/" + number);
        }

        function getCourseComments() {
            return getData("course-comments", "getCourseComments");
        }

        function getCourseCommentsByCode(courseCode) {
            return getData("course-comments/" + courseCode, "getCourseCommentsByCode:" + courseCode);
        }

        function getCourseSections() {
            return getData("course-sections", "getCourseSections");
        }

        function getCourseSectionByIndex(index) {
            return getData("course-section/" + index, "getCourseSectionByIndex:" + index);
        }

        function getCourseSectionBySection(discipline, number, section) {
            return getData("course-section/by-section/"  + discipline + "/" + number + "/" + section, "getCourseSectionBySection:" + discipline + "/" + number + "/" + section);
        }

        function getDepartments() {
            return getData("departments", "getDepartments");
        }

        function getDepartmentById(id) {
            return getData("department/by-id/" + id, "getDepartmentById:" + id);
        }

        function getDepartmentByName(name) {
            return getData("department/by-Name/" + name, "getDepartmentByName:" + name);
        }

        function getDisciplines() {
            return getData("disciplines", "getDisciplines");
        }

        function getDisciplineByAbbreviation(abbreviation) {
            return getData("department/by-abbreviation/" + abbreviation, "getDepartmentByAbbreviation:" + abbreviation);
        }

        function getInstructors() {
            return getData("instructors", "getInstructors");
        }

        function getInstructorByCourseCode(courseCode) {
            return getData("instructor/" + courseCode, "getInstructorByCourseCode:" + courseCode);
        }

        function getSemesters() {
            return getData("semesters", "getSemesters");
        }

        function searchTest() {
            return getData("searchTest", "searchTest");
        }

        function search(data) {
            return postData("search", "search", data);
        }

        // Generic api call function
        // Checks "cache" for data in case we've already made a particlular call
        // If it isn't there, it gets it from the server, stores it in the caches
        // Either way, it returns the data
        function getData(route, cacheKey) {
            var APIROUTE = "./api/v1/"
            var deferred = $q.defer();

            // If we don't have the data already, retrieve it
            if (!content.data.hasOwnProperty(cacheKey)) {
                $http.get(APIROUTE + route).then(handler);
                content.data[cacheKey] = deferred.promise;
            }

            // Either way, return promise with data
            return $q.when(content.data[cacheKey]);

            function handler(response) {
                deferred.resolve(response.data);
            }
        }
        
        function postData(route, cacheKey, data) {
            var APIROUTE = "./api/v1/"
            var deferred = $q.defer();
            var config = {
                headers : {
                    'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8;'
                }
            }

            data.courseNumber = (data.courseNumber === '') ? 'ALL' : data.courseNumber;
            data.instructorLastName = (data.instructorLastName === '') ? 'ALL' : data.instructorLastName;
            var ret = {};
            // If we don't have the data already, retrieve it
            if (!content.data.hasOwnProperty(cacheKey)) {
                console.log(APIROUTE + route + "/" + data.semesterId.toString() + "/" + data.discipline.toString() + "/" + data.departmentId.toString() + "/" + data.courseNumber.toString() + "/" + data.days.toString() + "/" + data.timeMod + "/" + data.time.toString() + "/" + data.instructorLastName);
                $http.post(APIROUTE + route + "/" + data.semesterId.toString() + "/" + data.discipline.toString() + "/" + data.departmentId.toString() + "/" + data.courseNumber.toString() + "/" + data.days.toString() + "/" + data.timeMod + "/" + data.time.toString() + "/" + data.instructorLastName, data, config).then(handler);
                ret = deferred.promise;
            }

            // Either way, return promise with data
            return $q.when(ret);

            function handler(response) {
                deferred.resolve(response.data);
            }
        }
    }
})();
