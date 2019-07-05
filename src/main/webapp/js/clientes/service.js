(function(){

    angular.module('pedidex')
        .service('ClienteService', ClienteService);

    ClienteService.$inject = ['$http'];

    function ClienteService ($http) {
        var service = this;

        var URL = 'http://localhost:8090/api/clientes';

        service.findAll = function (page, pageSize, filter, sort) {
            var urlFinal = URL + '?pageSize=' + (pageSize || 20)
                + '&page=' + (page || 1) + '&sort=' + (sort || 'nome');
            if (filter) {
                urlFinal += '&filterField=nome&filterData=' + filter;
            }
            
            return $http.get(urlFinal)
                .then(function(response) {
                    return {
                        data: response.data,
                        count: response.headers('X-Total-Length'),
                        page: response.headers('X-Current-Page'),
                        pageSize: response.headers('X-Page-Size'),
                        finish: response.status === 200
                    };
                });
        }

        service.findOne = function (id) {
            return $http.get(URL + '/' + id)
                .then(function(response) {
                    return response.data;
                });
        }

        service.insert = function (cliente) {
            return $http.post(URL, cliente)
                .then(function(response) {
                    return response.data;
                });
        }

        service.update = function (cliente) {
            return $http.put(URL + '/' + cliente.id, cliente)
                .then(function(response) {
                    return response.data;
                });
        }

        service.remove = function (id) {
            return $http.delete(URL + '/' + id);
        }

        return service;
    }

})();