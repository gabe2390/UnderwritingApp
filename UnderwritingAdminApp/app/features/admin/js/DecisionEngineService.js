admin.factory('DecisionEngineService', ["$http", function($http) {
	// currently tracked decision engines
	var engines = [];

	// the defaul settings for a new decision engine
	var engineDefaults = {
		"id" : 0,
		"minCredit" : 0,
		"minIncome" : 0,
		"maxDebt" : 0,
		"minAssetPoints": 0,
		"maxAmount" : 0
	};

	/**
	 *  DecisionEngine constructor
	 */
	function DecisionEngine(engine) {
		this.id = engine.id;
		this.minCredit = engine.minCredit;
		this.minIncome = engine.minIncome;
		this.maxDebt = engine.maxDebt;
		this.minAssetPoints = engine.minAssetPoints;
		this.maxAmount = engine.maxAmount;
	}

	/**
	 * Update this engine with an engine object received from the server
	 * {Object} engine 		The decision engine data received from the server
	 */
	DecisionEngine.prototype.update = function(engine) {
		this.id = engine.id;
		this.minCredit = engine.minCredit;
		this.minIncome = engine.minIncome;
		this.maxDebt = engine.maxDebt;
		this.minAssetPoints = engine.minAssetPoints;
		this.maxAmount = engine.maxAmount;
	}

	/**
	 *	Get an engine by its id
	 *  @param {Integer} id 	the engine's id
	 */
	function getEngineById(id) {
		for(var i in engines) {
			if(engines[i].id === id) {
				return engines[i];
			}
		}

		return 0;
	}

	/**
	 *  Update the engine with the specified id (both locally and on the server)
	 *
	 *  If it is a new engine, it will be persisted after receiving a response from the server
	 *  @params {DecisionEngine}	An engine to update
	 */
	function updateEngine(engine) {
		var isNew = engine.id === 0;

		$http({
		  method: 'GET',
  		  url: "features/admin/resources/DecisionEngineUpdate.json",
  		  data: engine
		}).then(
			function(response) {
				var updated = response.data.DecisionEngine;

				engine.update(updated);

				if(isNew) {
					engines.push(engine);
				}

				console.log(engines);
			}
		);
	}

	/**
	 * Create and return a new DecisionEngine
	 * @return {DecisionEngine}		The created decision engine
	 */
	function createEngine() {
		return new DecisionEngine(engineDefaults);
	}

	/**
	 * Get the decision engines as an array
	 * @return {Array} the currently tracked decision engines
	 */
	function getDecisionEngines() {
		return engines;
	}

	/**
	 * Remove the engine with the specified id
	 * @param {int} id
	 */
	function removeEngine(id) {
		$http({
		  method: 'POST',
  		  url: "features/admin/resources/RemoveDecisionEngine.json",
  		  data: id
		}).then(
			function(response) {
				if(response.data.status === "success") {
					//delete engines[id];
				};
			}
		);
	}

	/**
	 *	Update our decision engines to the current state on the server
	 */
	function importDecisionEngines() {
		$http({
		  method: 'GET',
  		  url: "features/admin/resources/DecisionEngine.json"
		}).then(
			function(response) {
				engines = [];
				var responseEngines = response.data.DecisionEngine;
				for(var i in responseEngines) {
					var engine = new DecisionEngine(responseEngines[i]);
					engines.push(engine);
				}
			}
		);		
	}

	// import the decision engines
	importDecisionEngines();

	return {
		getDecisionEngines : getDecisionEngines,
		removeEngine : removeEngine,
		createEngine: createEngine,
		updateEngine: updateEngine
	};
}])