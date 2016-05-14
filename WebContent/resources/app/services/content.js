(function() {

    angular
        .module('courseSearch')
        .service('content', Content);

    Content.$inject = ['$http', '$q'];

    function Content($http, $q) {
        var content = {
          getSemesters: getSemesters
        };
        content.data = {};

        //content.getSemesters = getSemesters;

        function getSemesters() {
            var cacheKey = "getSemesters";
            var deferred = $q.defer();

            // If we don't have the data already, retrieve it
            if (!content.data.hasOwnProperty(cacheKey)) {
                $http.get('./api/v1/semesters').then(function(response) {
                    deferred.resolve(response.data);
                });
                content.data[cacheKey] = deferred.promise;
            }
            // Either way, return promise with data
            return $q.when(content.data[cacheKey]);
        };

        return content;
    }






})();
