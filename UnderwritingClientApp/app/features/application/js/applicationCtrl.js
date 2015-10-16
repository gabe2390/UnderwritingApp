angular.module('underwritingClientAppApp.controllers',[])

.controller("applicationCtrl", function($scope, Request, $window){

		$scope.jobs=[];
	    $scope.assets=[];

		//set up job industry option menu
	    $scope.jobIndustry= [{
	    	value:'Technology',
	    	label: 'Technology'
	    },{
	    	value:'Medical',
	    	label: 'Medical'
	    },{
	    	value:'Human Services',
	    	label: 'Human Services'
	    },{
	    	value:'Industrial',
	    	label: 'Industrial'
	    },{
	    	value:'Automotive',
	    	label: 'Automotive'
	    },{
	    	value:'Other',
	    	label: 'Other'
	    }];

	    //set up asset option menu
	    $scope.assetTypes= [{
	    	value:'House',
	    	label: 'House'
	    },{
	    	value:'Car',
	    	label: 'Car'
	    },{
	    	value:'Stock',
	    	label: 'Stock'
	    },{
	    	value:'Bonds',
	    	label: 'Bonds'
	    }];

        /**
	    *	Template for a Job object
	    **/
	   	function Job(title,company,income,industry){
	   		this.title=title;
	   		this.company=company;
	   		this.income=income;
	   		this.industry=industry;
	   	}

	   	/**
	   	* Template for an Asset object
	   	**/
	   	function Asset(type,name, value){
	   		this.type=type;
	   		this.name=name;
	   		this.value=value;
	   	}

	     /**
	    * Adds a Job object to $scope.jobs[]
	    **/
	    $scope.addJob= function(){
	    	if($scope.jobs.length < 2){
	    		$scope.jobs.push(new Job());
	    	}	
	    }

	    /**
	    * Adds an Asset object to $scope.assets[]
	    **/
	    $scope.addAsset= function(){
	    	$scope.assets.push(new Asset());
	    }
    
	    /**
	    * Builds a single person object from the data received from the from
	    **/
	    $scope.getInfo = function(){

	    	var applicant={
	    		"firstName":$scope.user.firstName,
	    		"lastName":$scope.user.lastName,
	    		"age":$scope.user.age,
	    		"ssn":$scope.user.ssn,
	    		"male":$scope.user.gender,
	    		"jobs":$scope.jobs,
	    		"dependents":$scope.user.dependents,
	    		"married":$scope.user.married,
	    		"debt":$scope.user.debt,
	    		"creditscore":$scope.user.creditscore,
	    		"assets":$scope.assets
	    	};

	    	var request= {
	    		"Person":applicant,
	    		"reason": $scope.reason,
	    		"repaymentTerm": $scope.repaymentTerm,
	    		"amount": $scope.amount
	    	};

			console.log(request);
  			$scope.response = Request.createRequest(request);
  			$window.location.href = '#/response';
	    }
});
