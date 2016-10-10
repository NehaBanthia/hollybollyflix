/**
 * Created by Neha on 8/21/2016.
 */
/**
 * Created by Neha on 8/21/2016.
 */
(function () {
    'use strict';

    angular.module('movieflix')
        .service('ReviewService', ReviewService);

    ReviewService.$inject = ['$http', '$q', 'CONFIG'];

    function ReviewService($http, $q, CONFIG) {
        var self = this;
        self.getMovieReview=getMovieReview;
        self.submitReview=submitReview;
        function getMovieReview(id){
            return $http.get(CONFIG.API_HOST + '/review/'+id)
                .then(successFn, errorFn);
        }

        function submitReview(reviewDetails){
            return $http.post(CONFIG.API_HOST + '/review/create/',reviewDetails)
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