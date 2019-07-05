angular.module('pedidex', [
    'ui.router'
]);

angular.module('pedidex').config(AppConfig);

AppConfig.$inject = ['$stateProvider']
function AppConfig($stateProvider) {
    $stateProvider
        .state({
            name: 'dashboard',
            url: '/',
            templateUrl: '/views/dashboard.html'
        })
        .state({
            name: 'clientes',
            url: '/clientes',
            templateUrl: '/views/clientes/list.html',
            controller: 'ClienteListController',
            controllerAs: 'vm'
        })
        .state({
            name: 'clientesNovo',
            url: '/clientes/novo',
            templateUrl: '/views/clientes/form.html',
            controller: 'ClienteFormController',
            controllerAs: 'vm'
        })
        .state({
            name: 'clientesEditar',
            url: '/clientes/:id',
            templateUrl: '/views/clientes/form.html',
            controller: 'ClienteFormController',
            controllerAs: 'vm'
        });
}