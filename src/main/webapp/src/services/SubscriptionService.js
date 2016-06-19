(function(){
  'use strict';

  angular.module('airQuality')
      .service('subscriptionService', ['$q', '$http', '$log', SubscriptionService]);

  /**
   * SubscriptionService DataService
   *
   * @returns {{loadSubscriptionsForUser: Function}}
   * @constructor
   */

    function SubscriptionService($q, $http, $log) {

        // Promise-based API
        return {
            loadSubscriptionsForUser : function(userId, subscription) {

                //create new subscription and update subscriptions for current user
                var subscriptions=  $http.post('/airQualityMonitoring/users/'+userId+'/subscriptions', subscription).then(function() {

                    return $http.get('/airQualityMonitoring/users/'+userId+'/subscriptions').then(
                        function(result) {
                            console.log('get subscriptions from server');
                            return result.data;
                        });
                });

                return $q.when(subscriptions);

            }
        };

    }


})();
