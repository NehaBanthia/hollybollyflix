/**
 * Created by Neha on 8/20/2016.
 */
(function() {
    'use strict';

    angular.module('movieflix')
        .controller('NavBarController', NavBarController);

    NavBarController.$inject = ['$rootScope','$window'];

    function NavBarController($rootScope, $window) {

        var navbarVm = this;
        navbarVm.logout=logout;
        navbarVm.home=home;
        navbarVm.movieSearch="";
        //navbarVm.searchMovie=searchMovie;
        navbarVm.username=$rootScope.username;
        console.log(navbarVm.username);
        function logout(){
            $window.location.href="#/login";
        }

        function home(){
            $window.location.href="#/movieflix";
        }

        /*function searchMovie(){
            $window.location.href="#/movieflix-search/"+navbarVm.movieSearch;
        }*/
    }
})();