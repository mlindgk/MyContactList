app.controller("contactsController", function($scope, $http, $log) {
    $scope.filterOptions = {
        filterText: "",
        useExternalFilter: true
    }; 
    $scope.totalNoOfContacts = 0;
    $scope.contact = {
    		fistName: '',
    		lastName: '',
    		workEmail: '',
    		personalEmail: '',
    		workContactNo: '',
   			personalContactNo: ''
    };
    
    $scope.index = 0;

    $scope.pagingOptions = {
        pageSizes: [3, 500, 1000],
        pageSize: 3,
        currentPage: 1
    };	
    $scope.setPagingData = function(data, page, pageSize){	
        var pagedData = data.slice((page - 1) * pageSize, page * pageSize);
        $scope.myData = pagedData;
        $log.info(pagedData);
        $scope.totalNoOfContacts = data.length;
        if (!$scope.$$phase) {
            $scope.$apply();
        }
    };
    $scope.getPagedDataAsync = function (pageSize, page, searchText) {
        setTimeout(function () {
            var data;
            if (searchText) {
                var ft = searchText.toLowerCase();
                $http.get('controllers/showcontacts').success(function (largeLoad) {		
                    data = largeLoad.filter(function(item) {
                        return JSON.stringify(item).toLowerCase().indexOf(ft) != -1;
                    });
                    $scope.setPagingData(data,page,pageSize);
                });            
            } else {
                $http.get('controllers/showcontacts').success(function (largeLoad) {
                    $scope.setPagingData(largeLoad,page,pageSize);
                });
            }
        }, 100);
    };
	
    $scope.getPagedDataAsync($scope.pagingOptions.pageSize, $scope.pagingOptions.currentPage);
	
    $scope.$watch('pagingOptions', function (newVal, oldVal) {
        if (newVal !== oldVal && newVal.currentPage !== oldVal.currentPage) {
          $scope.getPagedDataAsync($scope.pagingOptions.pageSize, $scope.pagingOptions.currentPage, $scope.filterOptions.filterText);
        }
    }, true);
    $scope.$watch('filterOptions', function (newVal, oldVal) {
        if (newVal !== oldVal) {
          $scope.getPagedDataAsync($scope.pagingOptions.pageSize, $scope.pagingOptions.currentPage, $scope.filterOptions.filterText);
        }
    }, true);
	
    $scope.gridOptions = {
        data: 'myData',
        enablePaging: true,
		showFooter: true,
        totalNoOfContacts: 'totalDataItems',
        pagingOptions: $scope.pagingOptions,
        filterOptions: $scope.filterOptions
    };
    $scope.submit = function() {
        if ($scope.contact) {
        	if ($scope.selectedEmail == "work") {
        		$scope.contact.workEmail = $scope.emailAddress;
        	} else {
        		$scope.contact.personalEmail = $scope.emailAddress;
        	}
        	if ($scope.selectedContactNoType == "work") {
        		$scope.contact.workContactNo = $scope.contactNo;
        	} else {
        		$scope.contact.personalContactNo = $scope.contactNo;
        	}

          $http.post("/controllers/addcontact", this.contact);
        }
      };
      
	$scope.imgLogo = "/images/logo.png"; 
	$scope.imgAddItem = "/images/Add.png";
	$scope.imgDeleteItem = "/images/Delete.png";
	
	$scope.emailAddress = '';
	$scope.contactNo = '';
	
	$scope.selectedEmail = "work";
	$scope.selectedContactNoType = "work";

    $scope.addEmail = function() {	
    	if ($scope.selectedEmail == "work") {
    		$scope.contact.workEmail = $scope.emailAddress;
    	} else {
    		$scope.contact.personalEmail = $scope.emailAddress;
    	}
    	$scope.emailAddress = ''
    };

    $scope.addContactNo = function() {
    	if ($scope.selectedContactNoType == "work") {
    		$scope.contact.workContactNo = $scope.contactNo;
    	} else {
    		$scope.contact.personalContactNo = $scope.contactNo;
    	}
    	$scope.contactNo = '';
    };
    
});
/*app.controller("showContactsController", function($scope) {
$scope.myData = [{name: "Moroni", age: 50},
                 {name: "Tiancum", age: 43},
                 {name: "Jacob", age: 27},
                 {name: "Nephi", age: 29},
                 {name: "Enos", age: 34}];
 $scope.gridOptions = { 
     data: 'myData',
     columnDefs: [{field: 'name', displayName: '#'},
                  {field:'name', displayName:'Name'},
                  {field:'email', displayName:'Email Address'},
                  {field:'contactNo', displayName:'Contact No'}]
     };
});*/


//app.controller("addContacts");

