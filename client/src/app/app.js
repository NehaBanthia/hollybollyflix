/**
 * Created by Neha on 8/13/2016.
 */
(function() {
    'use strict';

    angular
        .module('movieflix', ['ngRoute'])
        .config(moduleConfig);

    function moduleConfig($routeProvider) {

        $routeProvider
            .when('/login', {
                templateUrl: 'app/views/login.html',
                controller: 'LoginController',
                controllerAs: 'loginVm'
            })
            .when('/signup', {
                templateUrl: 'app/views/sign-up.html',
                controller: 'SignUpController',
                controllerAs: 'signupVm'
            })
            .when('/forgotpassword', {
                templateUrl: 'app/views/forgot-password.html',
                controller: 'ForgotPasswordController',
                controllerAs: 'forgotPasswordVm'
            })
            .when('/movieflix', {
                templateUrl: 'app/views/movieflix-dashboard.html',
                controller: 'MovieflixDashboard',
                controllerAs: 'movieflixDashboardVm'
            })
            .otherwise({
                redirectTo: '/login'
            });
    }

})();