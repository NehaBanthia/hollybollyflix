/**
 * Created by Neha on 8/20/2016.
 */
(function() {
    'use strict';

    angular.module('movieflix')
        .controller('MovieSearchController', MovieSearchController);

    MovieSearchController.$inject = ['MovieService', '$routeParams','$rootScope','$window'];

    function MovieSearchController(MovieService, $routeParams,$rootScope,$window) {

        var movieSearchVm = this;
        movieSearchVm.showMovieDetails=showMovieDetails;
        movieSearchVm.searchedMovieList=[];
        movieSearchVm.username=$rootScope.username;
        init();

        function init(){
            if($routeParams.searchType==="latestMovies"){
                MovieService
                    .getLatestMovies("movie",0)
                    .then(function (movieList) {
                        movieSearchVm.searchedMovieList = movieList;
                    }, function (error) {
                        console.log(error)
                    });
            }
            if($routeParams.searchType==="latestSeries"){
                MovieService
                    .getLatestMovies("series",0)
                    .then(function (movieList) {
                        movieSearchVm.searchedMovieList = movieList;
                    }, function (error) {
                        console.log(error)
                    });
            }
            if($routeParams.searchType==="topMovies"){
                MovieService
                    .getTopRatedMovies("movie",0)
                    .then(function (movieList) {
                        movieSearchVm.searchedMovieList = movieList;
                    }, function (error) {
                        console.log(error)
                    });
            }
            if($routeParams.searchType==="topSeries"){
                MovieService
                    .getTopRatedMovies("series",0)
                    .then(function (movieList) {
                        movieSearchVm.searchedMovieList = movieList;
                    }, function (error) {
                        console.log(error)
                    });
            }
            if($routeParams.searchType==="title"){
                if($routeParams.searchText!==""){
                    MovieService
                        .searchMovieByTitle($routeParams.searchText)
                        .then(function (movieList) {
                            movieSearchVm.searchedMovieList = movieList;
                        }, function (error) {
                            console.log(error)
                        });
                }
            }
            if($routeParams.searchType==="genre"){
                MovieService
                    .getMoviesByGenre($routeParams.searchText)
                    .then(function (movieList) {
                        movieSearchVm.searchedMovieList = movieList;
                    }, function (error) {
                        console.log(error)
                    });
            }
        }

        function showMovieDetails(movieId){
            $window.location.href='#/movieflix-detail/'+movieId;
        }
    }
})();