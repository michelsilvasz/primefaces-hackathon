App.factory('ProprietarioService', function($http, API){
	return {
		list: function(){
			return $http.get(API+'proprietario');
		},
		create: function(item){
			return $http.post(API+'proprietario', item);
		},
		update: function(item, id){
			return $http.put(API+'proprietario/'+id, item);	
		},
		delete: function(id){
			return $http.delete(API+'proprietario/'+id);
		}
	}
})