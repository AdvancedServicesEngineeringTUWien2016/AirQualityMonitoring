(function(){

  angular
       .module('airQuality')
       .controller('UserController', [
          'userService', 'subscriptionService', '$mdSidenav', '$mdBottomSheet', '$timeout', '$log', '$http',
          UserController
       ]);

  /**
   * Main Controller
   * @param $scope
   * @param $mdSidenav
   * @param avatarsService
   * @constructor
   */
  function UserController( userService, subscriptionService, $mdSidenav, $mdBottomSheet, $timeout, $log, $http ) {
    var self = this;

    self.selected      = null;
    self.users         = [ ];
    self.subscriptions = [ ];
    self.subscription = null;
    self.radius = [ {radius:"2"}, {radius:"4"}, {radius: "6"}, {radius: "8"}, {radius: "10"} ];
    self.threshold = [ {threshold:"1"}, {threshold:"2"}, {threshold: "3"}, {threshold: "4"}, {threshold: "5"}, {threshold: "6"}, {threshold: "7"}, {threshold: "8"}, {threshold: "9"}, {threshold: "10"} ];
    self.selectUser    = selectUser;
    self.toggleList    = toggleUsersList;
    self.createNewSubscription    = createNewSubscription;

    // Load all registered users
    userService
          .loadAllUsers()
          .then( function( users ) {
            self.users    = [].concat(users);
            self.selected = users[0];
            self.subscriptions = [].concat(users[0].subscriptions);
            self.selected.hideSubscriptionForm = self.selected.subscribedUser ? false : true;
          });

    // *********************************
    // Internal methods
    // *********************************

    function createNewSubscription() {

        subscriptionService
            .loadSubscriptionsForUser(self.selected.id, self.subscription)
            .then( function( subscription ) {
                console.log(subscription);
                self.subscriptions = [].concat(subscription);
                self.selected.subscriptions = [].concat(subscription);

                self.subscription.latitude = "";
                self.subscription.longitude = "";
                self.subscription.radius = "";
            });
    }

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
      self.selected.hideSubscriptionForm = self.selected.subscribedUser ? false : true ;

    }

  }

})();
