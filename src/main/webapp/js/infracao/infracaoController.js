App.controller('InfracaoCtrl', function($scope, InfracaoService, $route,$routeParams,$location,EnvioService){
	$scope.infracao = {};
	$scope.veiculo = {};
	$scope.agente = {};
	$scope.TipoInfracao = {};
	$scope.LocalInfracao = {};
	$scope.infracaoEditar = {};
	$scope.infracaoLista = [];
	
	$scope.agenteA = {};
	$scope.agenteAtratado = {};
	$scope.veiculoA = {};

	$scope.notFound = false;
	
		InfracaoService.list().then(function(data){
		console.log(data.data);
		$scope.infracaoLista = data.data;
		console.log($scope.infracaoLista);
		if(data.data.length == 0){
			$scope.notFound = true;
		}
	},function(data){
		console.log("data", data);
	});
	
	$scope.infracaoEditar = EnvioService.getParametro();
	
	$scope.deletar = function(id){
		InfracaoService.delete(id).then(function(data){
			console.log(data);
			$route.reload();
		});	
	}
	
	$scope.editar = function(item){
		$scope.infracaoEditar = {};
		EnvioService.addParametro(item);
		$location.path('/editarInfracao');
	}

	$scope.atualizar = function(item){
		InfracaoService.update(item, item.idAgente).then(function(data){
				$location.path('/');
			});
	}
	
	$scope.adicionarInfracao = function(){
	
		$scope.infracao.agente = $scope.agenteA;
		$scope.infracao.tipoInfracao = $scope.TipoInfracao;
		$scope.infracao.locaisInfracoes = $scope.LocalInfracao;
		$scope.infracao.veiculo = $scope.veiculoA;
		InfracaoService.create($scope.infracao);
		
		console.log($scope.infracao);
		
	}
	$scope.converterData = function(item){
		var data = new Date(item);
		console.log(data);
	}
	
	$scope.buscarAgente = function(item){
		console.log(item)
		
		$scope.agenteStatus = InfracaoService.buscarAgente(item).then(function(data){
			console.log(data);
			$scope.agenteA = data.data;
			delete $scope.agenteA.infracoes;

			console.log($scope.agenteA);
			
			
		});
}
	
	$scope.buscarVeiculo = function(item){
		console.log(item);
		$scope.veiculoStatus = InfracaoService.buscarPlaca(item).then(function(data){
			
			$scope.veiculoA = data.data;
			delete $scope.veiculoA.modelo.veiculos;
			console.log($scope.veiculoA);
		});
	
}	
	
    google.charts.load('current', {'packages':['corechart']});
    google.charts.setOnLoadCallback(drawChart);
    function drawChart() {

      var data = google.visualization.arrayToDataTable([
     
        ['Task', 'Hours per Day'],
        ['Work',     $scope.valor],
        ['Eat',      2],
        ['Commute',  2],
        ['Watch TV', 2],
        ['Sleep',    7]
      ]);

      var options = {
        title: 'My Daily Activities'
      };

      var chart = new google.visualization.PieChart(document.getElementById('piechart'));

      chart.draw(data, options);
    }

 

    
    
});