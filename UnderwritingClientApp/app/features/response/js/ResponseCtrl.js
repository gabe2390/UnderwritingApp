angular.module('underwritingClientAppApp')
  .controller('ResponseCtrl', function ($scope, Request) {

  $scope.responses = Request.getResponses();
  
  $scope.$watch(function(){return Request.getResponses(); }, function(newVal, oldVal) {
		$scope.responses = newVal;
    });

});

 