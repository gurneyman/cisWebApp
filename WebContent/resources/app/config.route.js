(function () {
    'use strict';
    angular
    .module('courseSearch')
    .run(appRun);

/* @ngInject */
function appRun(routerHelper) {
    routerHelper.configureStates(getStates());
}

function getStates() {
    return [
        {
            state: 'home',
            config: {
                templateUrl: 'resources/app/home/home.view.html',
                url: '/',
                controller: 'HomeController'
            }
        },{
            state: 'course_search',
            config: {
                templateUrl: 'resources/app/course/search.html',
                url: '/course-search'
            }
        },{
            state: 'course_results',
            config: {
                templateUrl: 'resources/app/course/results.html',
                url: '/course-results'
            }
        },{
            state: 'course_details',
            config: {
                templateUrl: 'resources/app/course/details.html',
                url: '/course-details'
            }
        }
    ];
}

// routerHelperProvider.js
angular
    .module('courseSearch')
    .provider('routerHelper', routerHelperProvider);

routerHelperProvider.$inject = ['$locationProvider', '$stateProvider', '$urlRouterProvider'];
/* @ngInject */
function routerHelperProvider($locationProvider, $stateProvider, $urlRouterProvider) {
    /* jshint validthis:true */
    this.$get = RouterHelper;

    $locationProvider.html5Mode(true);

    RouterHelper.$inject = ['$state'];
    /* @ngInject */
    function RouterHelper($state) {
        var hasOtherwise = false;

        var service = {
            configureStates: configureStates,
            getStates: getStates
        };

        return service;

        ///////////////

        function configureStates(states, otherwisePath) {
            states.forEach(function(state) {
                $stateProvider.state(state.state, state.config);
            });
            if (otherwisePath && !hasOtherwise) {
                hasOtherwise = true;
                $urlRouterProvider.otherwise(otherwisePath);
            }
        }

        function getStates() { return $state.get(); }
    }
}
})();