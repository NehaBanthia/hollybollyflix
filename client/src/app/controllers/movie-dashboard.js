/**
 * Created by Neha on 8/13/2016.
 */
(function() {
    'use strict';

    angular.module('movieflix')
        .controller('MovieflixDashboard', MovieflixDashboard);

    MovieflixDashboard.$inject = ['$http', '$window'];

    function MovieflixDashboard($http, $window) {
        var movieflixDashboardVm = this;
        movieflixDashboardVm.latestMovies=[];
        init();
        function init(){

            $http.get('http://localhost:8080/movieflix/api/movies/sortByYear')
                .then(function(response){
                    movieflixDashboardVm.latestMovies=response.data;
                },function(error){

                })
        }
    }
})();