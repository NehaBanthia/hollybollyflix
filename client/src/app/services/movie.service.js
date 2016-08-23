/**
 * Created by Neha on 8/18/2016.
 */
(function () {
    'use strict';

    angular.module('movieflix')
        .service('MovieService',MovieService);

    MovieService.$inject = ['$http','$q','CONFIG'];

    function MovieService($http,$q,CONFIG) {
        var self = this;

        self.getMovies = getMovies;
        self.getMovieById = getMovieById;
        self.getTopRatedMovies = getTopRatedMovies;
        //self.getTopRatedSeries = getTopRatedSeries;
        self.getLatestMovies = getLatestMovies;
        //self.getLatestSeries = getLatestSeries;
        self.searchMovieByTitle=searchMovieByTitle;
        self.getMoviesByGenre=getMoviesByGenre;

        function getMovies() {
            return $http.get(CONFIG.API_HOST + '/movies/sortByYear')
                .then(successFn, errorFn);
        }
        function getMovieById(id) {
            return $http.get(CONFIG.API_HOST + '/movies/findById/' + id)
                .then(successFn, errorFn);
        }
        function getTopRatedMovies(movieType, isTopTen) {
            return $http.get(CONFIG.API_HOST + '/movies/getTopRatedMovieType/'+movieType+"/"+isTopTen)
                .then(successFn, errorFn);
        }
        function getLatestMovies(movieType, isTopTen) {
            return $http.get(CONFIG.API_HOST + '/movies/getTopLatestMovieType/'+movieType+"/"+isTopTen)
                .then(successFn, errorFn);
        }
        function getMoviesByGenre(genre) {
            return $http.get(CONFIG.API_HOST + '/movies/getMovieByGenre/'+genre)
                .then(successFn, errorFn);
        }

        /*function getTopRatedMovies() {
            return $http.get(CONFIG.API_HOST + '/movies/getTopRatedMovieType/movie')
                .then(successFn, errorFn);
        }
        function getTopRatedSeries() {
            return $http.get(CONFIG.API_HOST + '/movies/getTopRatedMovieType/series')
                .then(successFn, errorFn);
        }
        function getLatestMovies() {
            return $http.get(CONFIG.API_HOST + '/movies/getTopLatestMovieType/movie')
                .then(successFn, errorFn);
        }*/
        /*function getMovieComments(id){
            return $http.get(CONFIG.API_HOST + '/movies/getTopRatedMovieType/series')
                .then(successFn, errorFn);
        }*/
        /*function getLatestSeries() {
            return $http.get(CONFIG.API_HOST + '/movies/getTopLatestMovieType/series')
                .then(successFn, errorFn);
        }*/
        function searchMovieByTitle(searchTitle) {
            return $http.get(CONFIG.API_HOST + '/movies/findByTitle/'+searchTitle)
                .then(successFn, errorFn);
        }
        function successFn(response) {
            return response.data;
        }

        function errorFn(response) {
            return $q.reject('ERROR: ' + response.statusText)

        }

    }
})();