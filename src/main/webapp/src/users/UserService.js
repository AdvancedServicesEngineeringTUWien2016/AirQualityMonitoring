(function(){
  'use strict';

  angular.module('users')
      .service('userService', ['$q', '$http', '$log', UserService]);

  /**
   * Users DataService
   *
   * @returns {{loadAll: Function}}
   * @constructor
   */

  function UserService($q, $http, $log) {

    //get and unwrap users
    var users = $http.get('/airQualityMonitoring/users').then(
        function(result) {
          console.log('get users from server');
          console.log(result);
          return result.data;
        });

    // Promise-based API
    return {
      loadAllUsers : function() {
        return $q.when(users);
      }
    };
  }

})();
