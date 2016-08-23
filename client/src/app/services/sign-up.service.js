/**
 * Created by Neha on 8/18/2016.
 */
(function () {
    'use strict';

    angular.module('movieflix')
        .service('SignUpService', SignUpService);

    SignUpService.$inject = ['$http','$q', 'CONFIG'];

    function SignUpService($http,$q,CONFIG){
       var self = this;

        self.signUpUser=signUpUser;

        function signUpUser(userDetails) {
            return $http.post(CONFIG.API_HOST + '/user/create',userDetails)
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