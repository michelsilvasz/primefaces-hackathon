App.controller('ProprietarioCtrl', function($scope, ProprietarioService, $route,$routeParams,$location,EnvioService){
	$scope.proprietario = {};
	$scope.proprietarioEditar = {};
	$scope.proprietarios = [];
	$scope.telefones = {};
	
	$scope.notFound = false;
	ProprietarioService.list().then(function(data){
		$scope.proprietarios = data.data;
		if(data.data.length == 0){
			$scope.notFound = true;
		}
	},function(data){
		console.log("data", data);
	});
	$scope.proprietarioEditar = EnvioService.getParametro();
	
	$scope.deletar = function(id){
		ProprietarioService.delete(id).then(function(data){
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
	
	$scope.adicionarProprietario = function(proprietario){
		
		proprietario.telefones = [];
		proprietario.telefones.push($scope.telefones);
		console.log(proprietario);
		ProprietarioService.create(proprietario);
		delete $scope.proprietario;
		delete $scope.telefones;
		
	}
});