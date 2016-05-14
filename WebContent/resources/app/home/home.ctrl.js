(function () {
    'use strict';
    angular
        .module('courseSearch')
        .controller('HomeController', HomeController);

    HomeController.$inject = ['content'];

    function HomeController(content) {
        content.semester();
    }
})();