(function(){
	console.log('inside of logindirective.js');
		angular.module('login',[]).directive('loginDiv', [function () {
			return {
				restrict: 'ACE',
				templateUrl:'resources/directives/login.html',
				controller:'loginController'
			};
		}]).controller('loginController', ['$scope','$log', '$location','$rootScope','PluginService',function ($scope,$log,$location,$rootScope,PluginService) {
				$log.debug('Inside of loginController ');
				$log.debug('rootscope value '+ $rootScope.showMenu);
				toastr.info('Page loaded ');
				$scope.login = function(){
					//toastr.info("Please wait... validating your login details...");
					$scope.user.message = "Please wait... validating your login details...";
					$log.debug(angular.toJson($scope.user));
					PluginService.login($scope.user).then(function(response){
							var obj = response.data;
							$log.debug(angular.toJson(obj));
							if(obj.userName != "" && obj.userName != undefined && obj.status != "false" && obj.status != undefined){
								toastr.info("login success... Please wait redirecting to home page ...");
							$rootScope.showMenu = true;
							$rootScope.userName = $scope.user.userName;
							$location.path("/home");
							}
							else{
								toastr.warning(obj.message);
								$log.debug('message '+ obj.message);
								$scope.user.message = obj.message;
							}
							
					});
					
				}
		}])
})();