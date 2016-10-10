
(function() {
    'use strict';

    angular.module('movieflix')
        .controller('SignUpController', SignUpController);

    SignUpController.$inject = ['SignUpService','$window'];

    function SignUpController(SignUpService,$window) {
        var signupVm = this;

        signupVm.signUpUser=signUpUser;

        function signUpUser(){
            SignUpService
                .signUpUser({
                    firstName: signupVm.firstName, lastName: signupVm.lastName, emailId: signupVm.email, password: signupVm.password
                })
                .then(function (signUpUser) {
                    if(signUpUser){
                        $window.location.href='#/login';
                    }
                }, function (error) {
                    console.log(error);
                });
        }
    }
})();
