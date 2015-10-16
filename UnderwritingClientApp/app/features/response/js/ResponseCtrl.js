angular.module('underwritingClientAppApp')
  .controller('ResponseCtrl', function ($scope, Request) {
  $scope.requests = Request.getResponses().data;
  $scope.$watch(function(){return Request.getResponses();}, function(newVal, oldVal) {
		if (typeof newVal !== 'undefined') {
	$scope.requests = newVal;
        console.log(newVal);
    }});
  console.log($scope.requests);
  });

