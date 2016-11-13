App.controller('AgenteCtrl', function($scope, AgenteService, $route,$routeParams,$location,EnvioService){
	$scope.agente = {};
	$scope.agenteEditar = {};
	$scope.agenteLista = {};
	

	$scope.notFound = false;
	AgenteService.list().then(function(data){
		$scope.agenteLista = data.data;
		if(data.data.length == 0){
			$scope.notFound = true;
		}
	},function(data){
		console.log("data", data);
	});
	$scope.agenteEditar = EnvioService.getParametro();
	
	$scope.deletar = function(id){
		AgenteService.delete(id).then(function(data){
			console.log(data);
			$route.reload();
		});	
	}
	
	$scope.editar = function(item){
		$scope.agenteEditar = {};
		EnvioService.addParametro(item);
		$location.path('/editarAgente');
	}

	$scope.atualizar = function(item){
		AgenteService.update(item, item.idAgente).then(function(data){
				$location.path('/');
			});
	}
	
	$scope.adicionarAgente = function(agente){
	
		AgenteService.create(agente);
		console.log(agente.nome);
		delete $scope.agente;
		
	}
	$scope.converterData = function(item){
		var data = new Date(item);
		console.log(data);
	}
});