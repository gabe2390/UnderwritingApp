angular.module('underwritingClientAppApp.services', [])

.factory('Request',['$http', function($http){
	response = {};
	url = 'http://127.0.0.1:8080/new'

	function createRequest(request){
		$http({
			method: 'GET',
			url: url,
			data: request
		}).then(function successCallback(output){
			response = output;
			console.log(response)
			return response;
		})
	}

	function getResponses(){
		return response;
	}
		
return {
	createRequest: createRequest,
	getResponses: getResponses
};

}])

