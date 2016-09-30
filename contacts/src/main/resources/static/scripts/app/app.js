var app = angular.module('myModule', ['ngRoute']);

/* Routes Provider */
app.config(['$routeProvider', function($r, $scope) {
	
	$r.when('/', {
		templateUrl: 'components/dashboard.html',
		//controller: 'showContactsController'
	}).
	when('/contacts', {
		templateUrl: 'components/contacts.html',
		controller: 'contactsController'
	}).	
	when('/contactForm', {
		templateUrl: 'components/contactForm.html',
		controller: 'contactsController'
	});
	
}]);


