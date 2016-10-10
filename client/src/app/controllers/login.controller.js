/**
 * Created by Neha on 8/13/2016.
 */
(function() {
    'use strict';

    angular.module('movieflix')
        .controller('LoginController', LoginController);

    LoginController.$inject = ['LoginService','$window','$rootScope'];

    function LoginController(LoginService, $window, $rootScope) {
        var loginVm = this;

        loginVm.doLogin=doLogin;

        function doLogin() {
            if (loginVm.username && loginVm.usrPassword) {
                var userDetails={emailId: loginVm.username, password: loginVm.usrPassword};
                LoginService
                    .doLogin(userDetails)
                    .then(function (response) {
                        var auth = response;
                        if (auth.authorized) {
                            $rootScope.username = auth.user.firstName + " " + auth.user.lastName;
                            $rootScope.userId=auth.user.userId;
                            $window.location.href = '#/movieflix';
                        }
                        else {
                            loginVm.loginError="Invalid Credentials."
                        }
                    }, function (error) {
                        console.log(error);
                    });
            }
        }
    }
})();
