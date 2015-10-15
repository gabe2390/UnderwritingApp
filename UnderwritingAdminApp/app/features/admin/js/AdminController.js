var admin = angular.module('Underwriting.Admin', []);

/**
 * controller for the Admin view.
 */
admin.controller('AdminControl', [ "$scope", "DecisionEngineService", function($scope, DecisionEngineService) {

	$scope.decisionEngines = [];

	$scope.newEngine = undefined;

	$scope.$watchCollection(function() {
		return DecisionEngineService.getDecisionEngines();
	}, function(newVal, oldVal) {
		if (typeof newVal !== 'undefined') {
			$scope.decisionEngines = newVal;
		}
	})

	/**
	 * Creates new DecisionEngine
	 */
	$scope.createEngine = function(){
		$scope.newEngine = DecisionEngineService.createEngine();
	}

	/**
	 * Saves our newly created engine
	 */
	$scope.saveNewEngine = function(){
		DecisionEngineService.updateEngine($scope.newEngine);
		$scope.newEngine = undefined;
	}

	/**
	 * Allows us to edit an existing engine
	 */
	$scope.editExistingEngine = function(Engine){
		DecisionEngineService.updateEngine(Engine);
	}
}])