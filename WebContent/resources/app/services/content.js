(function() {

    angular
        .module('courseSearch')
        .service('content', Content);

    Content.$inject = ['$http', '$q'];

    function Content($http, $q) {
        var APIROUTE = "./api/v1/"
        var content = {
            data: {},
            getCourse: getCourse,
            getCourses: getCourses,
            getSemesters: getSemesters
        };
        return content;

        function getCourses() {
            return getData(APIROUTE + "courses", "getCourses");
        }
        function getCourse(id) {
            return getData(APIROUTE + "course/" + id, "getCourse:" + id);
        }

        function getSemesters() {
            return getData(APIROUTE + "semesters", "getSemesters");
        }


        // Generic api call function
        // Checks "cache" for data in case we've already made a particlular call
        // If it isn't there, it gets it from the server, stores it in the caches
        // Either way, it returns the data
        function getData(route, cacheKey) {
            var deferred = $q.defer();
            // If we don't have the data already, retrieve it
            if (!content.data.hasOwnProperty(cacheKey)) {
                $http.get(route).then(handler);
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
