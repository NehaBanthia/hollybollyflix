/**
 * Created by Neha on 8/18/2016.
 */
(function () {
    'use strict';

    angular.module('movieflix')
        .directive('validPasswordC',validPasswordC);

    function validPasswordC(){
        return {
            require: 'ngModel',
            link: function (scope, elm, attrs, ctrl) {
                ctrl.$parsers.unshift(function (viewValue, $scope)
                    /**
                     * This function is added to the list of the $parsers.
                     * It will be executed the DOM (the view value) change.
                     * Array.unshift() put it in the beginning of the list, so
                     * it will be executed before all the other
                     */
                {
                    var noMatch = viewValue != scope.signUpForm.pword.$viewValue
                    ctrl.$setValidity('noMatch', !noMatch)
                })
            }
        }
    }

})();