(function(){

    angular.module('pedidex')
        .controller('ClienteFormController', ClienteFormController);

    ClienteFormController.$inject = ['ClienteService', '$state', '$stateParams'];

    function ClienteFormController (ClienteService, $state, $stateParams) {
        var vm = this;
        vm.titulo = 'Novo Cliente';
        vm.cliente = {};

        if ($stateParams.id) {
            ClienteService.findOne($stateParams.id)
                .then(function(data) {
                    vm.titulo = 'Editando Cliente';
                    vm.cliente = data;
                });
        }

        vm.save = function () {
            if (vm.cliente.id) {
                ClienteService.update(vm.cliente)
                    .then(function (data) {
                        alert('Cliente atualizado com sucesso!!!');
                        $state.go('clientes');
                    })
                    .catch(function (error) {
                        vm.errors = error.data;
                        alert('Erro ao atualizar cliente');
                    });
            } else {
                ClienteService.insert(vm.cliente)
                    .then(function (data) {
                        alert('Cliente inserido com sucesso!!!');
                        $state.go('clientes');
                    })
                    .catch(function (error) {
                        vm.errors = error.data;
                        alert('Erro ao atualizar cliente');
                    });
            }
        };

    }

})();

