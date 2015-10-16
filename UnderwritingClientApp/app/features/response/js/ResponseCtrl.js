angular.module('underwritingClientAppApp')
  .controller('ResponseCtrl', function ($scope, Request) {
  $scope.requests = Request.getResponses();
  
  $scope.$watch(function(){return Request.getResponses();}, function(newVal, oldVal) {
		if (typeof newVal !== oldVal) {
		$scope.requests = newVal;
        console.log(newVal);
    }});
  });

 