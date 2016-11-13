App.controller('VeiculoCtrl', function($scope, VeiculoService, $route,$routeParams,$location,EnvioService){
	$scope.veiculos = {};
	$scope.veiculoEditar = {};
	$scope.categorias = [{descricaoCategoria: 'Passeio'},{descricaoCategoria: 'Caminhao/Caminhonete'},{descricaoCategoria: 'Moto'},{descricaoCategoria: 'Van'}];
	$scope.modelo = {};
	$scope.estados = [{nome: 'Distrito Federal'},{nome: 'Goias'},{nome: 'Sao Paulo'},{nome:"Rio de Janeiro"}];
	$scope.cpf
	$scope.proprietario = {};

	
	$scope.notFound = false;
	VeiculoService.list().then(function(data){
		$scope.listaVeiculo = data.data;
		if(data.data.length == 0){
			$scope.notFound = true;
		}
	},function(data){
		console.log("data", data);
	});
	$scope.veiculoEditar = EnvioService.getParametro();
	
	$scope.deletar = function(id){
		VeiculoService.delete(id).then(function(data){
			console.log(data);
			$route.reload();
		});	
	}
	
	$scope.editar = function(item){
		$scope.veiculoEditar = {};
		EnvioService.addParametro(item);
		$location.path('/editarVeiculo');
	}

	$scope.atualizar = function(item){
		VeiculoService.update(item, item.placa).then(function(data){
				$location.path('/');
			});
	}
	
	$scope.adicionarVeiculo = function(veiculo){
		
		
		/*retirar scope e testar
		$scope.modelo.categoria = $scope.categoria;
		$scope.veiculos.modelo = $scope.modelo;
		$scope.veiculos.proprietario = $scope.proprietario;
		console.log($scope.veiculos);
		
		*/
		
		$scope.modelo.categoria = $scope.categoria;
		$scope.veiculos.modelo = $scope.modelo;
		$scope.veiculos.proprietario = $scope.proprietario;

		console.log($scope.veiculos);

		
		VeiculoService.create($scope.veiculos);
		delete $scope.veiculos;
		delete $scope.categoria;
		delete $scope.modelo;
	}
	
	$scope.pesquisarProprietario = function(item){
		
		$scope.veiculoStatus = VeiculoService.pesquisarProprietario(item).then(function(data){
			
			$scope.proprietario = data.data;
			delete $scope.proprietario.veiculos; 
			
			console.log($scope.proprietario);
			
		});
	}
	converterData = function(item){
		return new Date(item);
	}
});