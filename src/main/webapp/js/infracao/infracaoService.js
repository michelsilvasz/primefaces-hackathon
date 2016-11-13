App.factory('InfracaoService', function($http, API){
	return {
		list: function(){
			return $http.get(API+'infracao');
		},
		create: function(item){
			return $http.post(API+'infracao', item);
		},
		update: function(item, id){
			return $http.put(API+'infracao/'+id, item);	
		},
		delete: function(id){
			return $http.delete(API+'infracao/'+id);
		},
		buscarAgente: function(cpf){
			return $http.get(API+'infracao/buscarAgente/'+cpf);
		},
		buscarPlaca: function(placa){
			return $http.get(API+'infracao/buscarVeiculo/'+placa);
		}
	}
})