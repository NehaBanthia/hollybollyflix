/**
 * Created by Neha on 8/19/2016.
 */
(function() {
    'use strict';

    angular.module('movieflix')
        .controller('MovieDetailController', MovieDetailController);

    MovieDetailController.$inject = ['MovieService', 'CommentService','ReviewService','$routeParams','$rootScope'];

    function MovieDetailController(MovieService,CommentService, ReviewService,$routeParams,$rootScope) {

        var movieDetailVm = this;
        movieDetailVm.details={};
        movieDetailVm.movieComments=[];
        movieDetailVm.movieReview="";
        movieDetailVm.submitComment=submitComment;
        movieDetailVm.submitReview=submitReview;
        movieDetailVm.reviewOption=[{name:"0",value:0},
            {name:"1",value:1},
            {name:"2",value:2},
            {name:"3",value:3},
            {name:"4",value:4},
            {name:"5",value:5}]
        movieDetailVm.selectedReview=movieDetailVm.reviewOption[0];
        movieDetailVm.username=$rootScope.username;
        init();
        function init() {
            console.log('MovieDetailController');

            MovieService
                .getMovieById($routeParams.id)
                .then(function (details) {
                    movieDetailVm.details = details;
                }, function (error) {
                    console.log(error)
                });

            CommentService
                .getMovieComments($routeParams.id)
                .then(function (comments) {
                    movieDetailVm.movieComments = comments;
                }, function (error) {
                    console.log(error)
                });

            ReviewService
                .getMovieReview($routeParams.id)
                .then(function (review) {
                    movieDetailVm.movieReview = review;
                }, function (error) {
                    console.log(error)
                });


        }

        function submitComment(){
            console.log(movieDetailVm.selectedReview);
            var commentDetails={comment:movieDetailVm.userComment,movie:{id:$routeParams.id},user:{userId:$rootScope.userId}}
            CommentService
                .submitComment(commentDetails)
                .then(function (response) {
                    CommentService
                        .getMovieComments($routeParams.id)
                        .then(function (comments) {
                            movieDetailVm.movieComments = comments;
                        }, function (error) {
                            console.log(error)
                        });
                }, function (error) {
                    console.log(error)
                });
        }

        function submitReview(){
            var reviewDetails={review:movieDetailVm.selectedReview.value,movie:{id:$routeParams.id},user:{userId:$rootScope.userId}}
            ReviewService
                .submitReview(reviewDetails)
                .then(function (response) {
                    ReviewService
                        .getMovieReview($routeParams.id)
                        .then(function (review) {
                            movieDetailVm.movieReview = review;
                        }, function (error) {
                            console.log(error)
                        });
                }, function (error) {
                    console.log(error)
                });
        }
    }
})();
