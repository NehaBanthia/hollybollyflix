/**
 * Created by Neha on 8/13/2016.
 */
(function() {
    'use strict';

    angular.module('movieflix')
        .controller('LoginController', LoginController);

    LoginController.$inject = ['$http','$window','$scope'];

    function LoginController($http,$window,$scope) {
        var loginVm = this;
        loginVm.doLogin=doLogin;

        function doLogin(){
            if(loginVm.username && loginVm.usrPassword){
                $http.post('http://localhost:8080/movieflix/api/user/auth',{emailId:loginVm.username,password:loginVm.usrPassword})
                    .then(function(response){
                        var auth=response.data;
                        if(auth.authorized){
                            $scope.username=auth.user.firstName+" "+auth.user.lastName;
                            $window.location.href='#/movieflix';
                        }
                        else{
                            loginVm.loginError='Invalid credentials';
                        }
                    },function(error){

                    })
            }
        }
    }
})();
