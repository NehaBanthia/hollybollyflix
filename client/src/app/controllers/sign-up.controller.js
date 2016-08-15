
(function() {
    'use strict';

    angular.module('movieflix')
        .controller('SignUpController', SignUpController).directive('validPasswordC',validPasswordC);

    SignUpController.$inject = ['$http','$window'];

    function SignUpController($http,$window) {
        var signupVm = this;
        signupVm.signUpUser=signUpUser;

        function signUpUser(){
            //if(signupVm.firstName && signupVm.lastName && signupVm.email && signupVm.password && signupVm.confirmPassword){
                $http.post('http://localhost:8080/movieflix/api/user/create',{firstName:signupVm.firstName,
                    lastName:signupVm.lastName,emailId:signupVm.email,password:signupVm.password})
                    .then(function(response){
                        if(response.data){
                            $window.location.href='#/login';
                        }
                    },function(error){});
           // }
        }
    }
    function validPasswordC(){
        return {
            require: 'ngModel',
            link: function (scope, elm, attrs, ctrl) {
                ctrl.$parsers.unshift(function (viewValue, $scope) {
                    var noMatch = viewValue != scope.signUpForm.pword.$viewValue
                    ctrl.$setValidity('noMatch', !noMatch)
                })
            }
        }
    }
})();
