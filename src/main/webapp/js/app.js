var App = angular.module('App', [
'ngRoute',
'controllers',
'services'

]);

App.config(function($routeProvider){
	$routeProvider
	.when('/CadastrarAgente', {
		templateUrl: 'views/agente/CadastrarAgente.html',
		controller: 'AgenteCtrl'
	})

	.when('/buscarAgentes', {
		templateUrl: 'views/agente/buscarAgentes.html',
		controller: 'AgenteCtrl'
	})

	.when('/editarAgente', {
		templateUrl: 'views/agente/editarAgente.html',
		controller: 'AgenteCtrl'
	})
	.when('/', {
		templateUrl: 'inicio.html',
		controller: 'AgenteCtrl'
	})
	.when('/cadastrarVeiculo', {
		templateUrl: 'views/veiculo/CadastrarVeiculo.html',
		controller: 'VeiculoCtrl'
	})
	.when('/CadastrarProprietario', {
		templateUrl: 'views/proprietario/CadastrarProprietario.html',
		controller: 'ProprietarioCtrl'
	})
		.when('/cadastrarInfracao', {
		templateUrl: 'views/infracao/cadastrarInfracao.html',
		controller: 'InfracaoCtrl'
	})
	.when('/agente',{
		templateUrl: 'views/agente/agente.html',
		controller: 'InfracaoCtrl'
	})
	.when('/listarInfracoes', {
		templateUrl: 'views/infracao/listaInfracoes.html',
		controller: 'InfracaoCtrl'
	})
});

App.value('API', 'http://localhost:8080/primefaces-app/service/');