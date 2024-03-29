angular.module('underwritingClientAppApp.services', [])

.factory('Request',['$http', function($http){
	response = [];
	url = 'http://127.0.0.1:8080/new'

	function createRequest(request){
		for(i in request.applicant.assets) {
			request.applicant.assets[i].type = request.applicant.assets[i].type.value;
		}

		request.reason = request.reason.value;

		$http({
			method: 'POST',
			url: url,
			data: request
		}).then(function successCallback(output){
			response = output.data;
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

