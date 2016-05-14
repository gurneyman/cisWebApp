(function(){

  angular
    .module('courseSearch')
    .service('content', Content);

  Content.$inject = ['$http'];

  function Content($http) { return this; }

  Content.prototype.semester = Semester;

  

  function Semester() {
    console.log("HI, I'm before the constructor");
  }
})();