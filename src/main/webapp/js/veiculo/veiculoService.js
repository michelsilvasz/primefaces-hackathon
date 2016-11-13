App.factory('VeiculoService', function($http, API){
	return {
		list: function(){
			return $http.get(API+'veiculo');
		},
		create: function(item){
			return $http.post(API+'veiculo', item);
		},
		update: function(item, id){
			return $http.put(API+'veiculo/'+id, item);	
		},
		delete: function(id){
			return $http.delete(API+'veiculo/'+id);
		},
		pesquisarProprietario: function(id){
			return $http.get(API+'veiculo/pesquisarProprietario/'+id);
		}
	}
})