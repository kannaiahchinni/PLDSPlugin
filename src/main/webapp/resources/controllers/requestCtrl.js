(function(){
		
	angular.module('PLDSPlugin').controller('requestCtrl',['$scope','$log','PluginService', '$http',function($scope,$log,PluginService,$http){
	
			$scope.loading = false;
		$scope.requestLogin = function(){
			$scope.loading = true;
			$scope.user.message = "Please wait, sending request to admin..";
			PluginService.requestLogin($scope.user).then(
			
			function(success){
				$scope.user ={};
				$scope.user.message = "request sent to admin successfully ... ";
				$log.debug("request sent to admin successfully ... ");
				$scope.loading = false;
			},
			function(err){
				$scope.user.message = "request failed, Please try once again ...... ";
				$log.debug('request failed, Please try once again ...');
				$scope.loading = false;
			}
		);
		}
		
	}]);
	
})();