/**
 * Created by Neha on 8/13/2016.
 */
(function() {
    'use strict';

    angular.module('movieflix')
        .controller('MovieflixDashboard', MovieflixDashboard);

    MovieflixDashboard.$inject = ['MovieService','$window','$rootScope'];

    function MovieflixDashboard(MovieService,$window,$rootScope) {

        var movieflixDashboardVm = this;
        movieflixDashboardVm.showMovieDetails=showMovieDetails;
        movieflixDashboardVm.latestMovies = [];
        movieflixDashboardVm.latestSeries = [];
        movieflixDashboardVm.topRatedMovies = [];
        movieflixDashboardVm.topRatedSeries = [];
        movieflixDashboardVm.searchMovie=searchMovie;
        movieflixDashboardVm.username=$rootScope.username;
        movieflixDashboardVm.searchText="";
        movieflixDashboardVm.searchMovieTitle=searchMovieTitle;
        init();
        function init() {

                MovieService
                    .getLatestMovies("movie",1)
                    .then(function (response) {
                        console.log(response);
                    movieflixDashboardVm.latestMovies = response;

                }, function (error) {
                    console.log(error)
                });

            MovieService
                .getLatestMovies("series",1)
                .then(function (response) {
                    console.log(response);
                    movieflixDashboardVm.latestSeries = response;

                }, function (error) {
                    console.log(error)
                });

            MovieService
                .getTopRatedMovies("movie",1)
                .then(function (response) {
                    console.log(response);
                    movieflixDashboardVm.topRatedMovies = response;

                }, function (error) {
                    console.log(error)
                });

            MovieService
                .getTopRatedMovies("series",1)
                .then(function (response) {
                    console.log(response);
                    movieflixDashboardVm.topRatedSeries = response;

                }, function (error) {
                    console.log(error)
                });

        }

        function showMovieDetails(movieId){
            $window.location.href='#/movieflix-detail/'+movieId;
        }

        function searchMovie(searchType,searchText){
            $window.location.href='#/movieflix-search/'+searchType+"/"+searchText;
        }

        function searchMovieTitle(){
            $window.location.href='#/movieflix-search/title/'+movieflixDashboardVm.searchText;
        }
    }

})();
