(function() {
    angular
        .module('courseSearch')
        .service('content', Content);

    Content.$inject = ['$http', '$q'];

    function Content($http, $q) {
        var content = {
            data: {},
            getCourse: getCourse,
            getCourses: getCourses,
            getInstructor: getInstructor,
            getInstructors: getInstructors,
            getSemesters: getSemesters
        };
        return content;

        function getCourses() {
            return getData("courses", "getCourses");
        }

        function getCourse(id) {
            return getData("course/" + id, "getCourse:" + id);
        }

        function getInstructors() {
            return getData("instructors", "getInstructors");
        }

        function getInstructor(code) {
            return getData("instructor/" + code, "getInstructor:" + code);
        }

        function getSemesters() {
            return getData("semesters", "getSemesters");
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
    }
})();
