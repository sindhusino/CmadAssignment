(function() {
	var app = angular.module('Blog', [ 'ngRoute' ]);

	app.config([ '$routeProvider', function($routeProvider) {
		console.log("Route provider config");
		$routeProvider.when('/Contact', {
			templateUrl : 'Contact.html',
			controller : 'ContactController'
		}).when('/About', {
			templateUrl : 'About.html',
			controller : 'AboutController'
		}).when('/Logout', {
			templateUrl : 'Logout.html',
			controller : 'LogoutController'
		}).when('/Welcome', {
			templateUrl : 'Welcome.html',
			controller : 'WelcomeController'
		}).when('/Create', {
			templateUrl : 'Create.html',
			controller : 'CreateController'
		}).when('/Bloggers', {
			templateUrl : 'Bloggers.html',
			controller : 'BloggersController'
		}).otherwise({
			redirecTo : '/',
			templateUrl : 'Login.html',
			controller : 'LoginController'
		});
	} ]);
	app.service('sharedProperties', function () {
		var property = {};

        return {
            getProperty: function () {
                return property;
            },
            setProperty: function(value) {
                property = value;
            }
        };
	});
	app.controller("LoginController", function($http, $log, $scope, $location) {
		var controller = this;
		$scope.Users = {};
		$scope.loginDisplay = true;
		
		$scope.Login = function(value) {
			$scope.user = value;
			console.log("inside login");
			var formGet = $http.post(
					'blog/user/check/email',
					$scope.user).success(function(data) {
				console.log(data);
				//$scope.users.push(angular.copy($scope.user));
				//$scope.Users.push($scope.User);
//				$scope.form = false;
				$scope.loginDisplay = false;
				$location.url('/Welcome');
				console.log(data);
			});
			
		}

		$scope.Reg = function(value) {
			$scope.User = value;
			console.log("inside register");
			var formPost = $http.post(
					'blog/user/create',
					$scope.User).success(function(data) {
				console.log(data);
				$scope.form = false;
				$location.url('/');
			});
		};

		$scope.showReg = function() {
			document.getElementById('login-wrapper').style.display = "none";
			document.getElementById('reg-wrapper').style.display = "inline";
			document.getElementById('loginbutton').style.background = "#dfd7c6";
			document.getElementById('regbutton').style.background = "#c3b595";
		};

		$scope.showLogin = function() {
			document.getElementById('login-wrapper').style.display = "inline";
			document.getElementById('reg-wrapper').style.display = "none";
			document.getElementById('loginbutton').style.background = "#c3b595";
			document.getElementById('regbutton').style.background = "#dfd7c6";
		};
	});
	app.controller('BloggersController', ['$scope','$http','$log', '$location', 'sharedProperties','$route', function($scope,$http,$log,$location,sharedProperties,$route) {
		$scope.loginDisplay = false;
		console.log("inside ContactController: ID: "+$scope.id);
		$scope.id = sharedProperties.getProperty();
		
		var formGet = $http.get(
				'blog/page/blogpagetitle/'+$scope.id,
				$scope.User).success(function(data) {
					$scope.loginDisplay = false;
			console.log(data);
			$scope.data = data;
			$scope.comment = $scope.data.comment;
			
		});
		
		$scope.Contact = function() {
			console.log("inside Contact");
			$location.url('/Contact');
		};
		
		$scope.About = function() {
			console.log("inside About");
			$location.url('/About');
		};
		
		$scope.HomeNav = function() {
			console.log("inside Home");
			$location.url('/Welcome');
		};
		$scope.Logout = function() {
			console.log("inside logout");
			$location.url('/');
		};
		
		$scope.Submit = function(value) {
			$scope.comment = value;
			console.log("inside Submit : ID"+ $scope.id);
			console.log($scope.comment);
			console.log($scope.comment.content);
			$http.post('blog/page/comment/'+$scope.id, $scope.comment).success(
					function(data, status, headers, config) {
						console.log("success");
					});
			$route.reload();
		};
	}]);
	
	app.controller('HomeController', ['$scope','$http','$log','$location', function($scope,$http,$log,$location) {
		$scope.loginDisplay = false;
		console.log("insode BloggersController");
	}]);
	
	app.controller('WelcomeController', ['$scope','$http','$log','$location','sharedProperties','$route', function($scope,$http,$log,$location, sharedProperties, $route) {
		$scope.loginDisplay = false;
		console.log("inside WelcomeController");
		$scope.titles = [];
		
		var formGet = $http.get(
				'blog/page',
				$scope.User).success(function(data) {
			console.log(data);
			$scope.titles = data;
			$scope.titles.push($scope.titles);
			$scope.loginDisplay = false;
		});
		
		$scope.About = function() {
			console.log("inside about");
			$location.url('/About');
		};
		
		$scope.Blog = function(value) {
			$scope.value = value;
			console.log("blog function");
			console.log($scope.value.id);
			sharedProperties.setProperty($scope.value.id);
			$location.url('/Bloggers');
			
		};
		
		$scope.Search = function(value) {
			$scope.title = value;
			console.log("inside Search");
			var formGet = $http.get(
					'blog/user/titles',
					$scope.title).success(function(data) {
				console.log(data);
				$scope.titles = data;
				$route.reload();
			});
			
		};
		
		$scope.Contact = function() {
			console.log("inside Contact");
			$location.url('/Contact');
		};
		
		$scope.Create = function() {
			console.log("inside create");
			$location.url('/Create');
		};
		$scope.Logout = function() {
			console.log("inside logout");
			$location.url('/');
		};
	}]);
	
	app.controller('LogoutController', ['$scope','$http','$log','$location', function($scope,$http,$log,$location) {
		$scope.loginDisplay = false;
		console.log("inside LogoutController");
	}]);
	
	app.controller('AboutController', ['$scope','$http','$log','$location', function($scope,$http,$log,$location) {
		$scope.loginDisplay = false;
		console.log("inside AboutController");
		$scope.Contact = function() {
			console.log("inside Contact");
			$location.url('/Contact');
		};
		
		$scope.HomeNav = function() {
			console.log("inside create");
			$location.url('/Welcome');
		};
		$scope.Logout = function() {
			console.log("inside logout");
			$location.url('/');
		};
	}]);
	
	app.controller('CreateController', ['$scope','$http','$log','$location', function($scope,$http,$log,$location) {
		$scope.loginDisplay = false;
		
		console.log("inside CreateController");
		$scope.Contact = function() {
			console.log("inside Contact");
			$location.url('/Contact');
		};
		
		$scope.HomeNav = function() {
			console.log("inside create");
			$location.url('/Welcome');
		};
		$scope.Logout = function() {
			console.log("inside logout");
			$location.url('/');
		};
		
		$scope.Submit = function(value) {
			$scope.data = value;
			$http.post("blog/page/blogpage", $scope.data).success(
					function(data, status, headers, config) {
						console.log("success");
						$location.url('/Welcome');
					}).error(
							function(data, status, headers, config) {
								console.log("error");
								$location.url('/Welcome');
							});
			
			
		};
	}]);
	
	app.controller('ContactController', ['$scope','$http','$log','$location', function($scope,$http,$log,$location) {
		$scope.loginDisplay = false;
		console.log("inside ContactController");
		$scope.About = function() {
			console.log("inside Contact");
			$location.url('/About');
		};
		
		$scope.HomeNav = function() {
			console.log("inside create");
			$location.url('/Welcome');
		};
		$scope.Logout = function() {
			console.log("inside logout");
			$location.url('/');
		};
	}]);
})();
