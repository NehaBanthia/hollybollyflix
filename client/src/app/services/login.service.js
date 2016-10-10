(function () {
    'use strict';

    angular.module('movieflix')
        .service('LoginService', LoginService);

    LoginService.$inject = ['$http','$q', 'CONFIG'];

    function LoginService($http,$q, CONFIG){
        var self = this;

        self.doLogin=doLogin;

        function doLogin(UserDetails) {
            return $http.post(CONFIG.API_HOST + '/user/auth', UserDetails)
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
