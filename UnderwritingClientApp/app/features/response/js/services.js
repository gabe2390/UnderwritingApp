angular.module('underwritingClientAppApp.services', [])

.factory('Request',['$http', function($http){
	response = {};
	url = 'features/response/resources/dummydata.json'

	function createRequest(request){
		$http({
			method: 'GET',
			url: url,
			data: request
		}).then(function successCallback(output){
			response = output.data;
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

