(function(){

  angular
       .module('users')
       .controller('UserController', [
          'userService', '$mdSidenav', '$mdBottomSheet', '$timeout', '$log', '$http',
          UserController
       ]);

  /**
   * Main Controller for the Angular Material Starter App
   * @param $scope
   * @param $mdSidenav
   * @param avatarsService
   * @constructor
   */
  function UserController( userService, $mdSidenav, $mdBottomSheet, $timeout, $log, $http ) {
    var self = this;

    self.selected      = null;
    self.users         = [ ];
    self.subscriptions = [ ];
    self.selectUser    = selectUser;
    self.toggleList    = toggleUsersList;

    // Load all registered users
    userService
          .loadAllUsers()
          .then( function( users ) {
            self.users    = [].concat(users);
            self.selected = users[0];
            self.subscriptions = [].concat(users[0].subscriptions);
            //  console.log(self.subscriptions);
          });

    // *********************************
    // Internal methods
    // *********************************

    /**
     * Hide or Show the 'left' sideNav area
     */
    function toggleUsersList() {
      $mdSidenav('left').toggle();
    }

    /**
     * Select the current avatars
     * @param menuId
     */
    function selectUser ( user ) {
      self.selected = angular.isNumber(user) ? $scope.users[user] : user;
      self.subscriptions = [].concat(self.selected.subscriptions);
      console.log(self.subscriptions);
    }

  }

})();
