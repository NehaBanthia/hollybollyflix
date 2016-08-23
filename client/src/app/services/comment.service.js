/**
 * Created by Neha on 8/21/2016.
 */
(function () {
    'use strict';

    angular.module('movieflix')
        .service('CommentService', CommentService);

    CommentService.$inject = ['$http', '$q', 'CONFIG'];

    function CommentService($http, $q, CONFIG) {
        var self = this;
        self.getMovieComments=getMovieComments;
        self.submitComment=submitComment;
        function getMovieComments(id){
            return $http.get(CONFIG.API_HOST + '/comment/findMovieComments/'+id)
                .then(successFn, errorFn);
        }

        function submitComment(commentDetails){
            return $http.post(CONFIG.API_HOST + '/comment/create/',commentDetails)
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