angular.module('underwritingClientAppApp')
  .controller('ResponseCtrl', function ($scope, Request) {
  $scope.requests = Request.getResponses().data;
  $scope.$watch(function(Request){return Request.getResponse;}, function(newVal, oldVal) {
		if (typeof newVal !== 'undefined') {
	$scope.requests = newVal;
        console.log(newVal);
    }});
  console.log($scope.requests);
  });

