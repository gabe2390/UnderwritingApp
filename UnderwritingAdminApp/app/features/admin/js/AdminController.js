var controllers = angular.module('Admin.controller', []);

controllers.controller('AdminControl', function($scope, DecisionEngineService) {
$scope.decisionEngines=[];
$scope.newEngine = undefined;
	$scope.$watch(function() {
		return DecisionEngineService.getDecisionEngines();
	}, function(newVal, oldVal) {
		if (typeof newVal !== 'undefined') {
			$scope.decisionEngines[] = newVal;
		}

$scope.createEngine = function(){
	$scope.newEngine = DecisionEngineService.createEngine();
}

$scope.saveNewEngine = function(){
	DecisionEngineService.addEngine($scope.newEngine);
	$scope.newEngine = undefined;
}

$scope.editExistingEngine = function(Engine){
	DecisionEngineService.updateEngine(Engine);
}

}