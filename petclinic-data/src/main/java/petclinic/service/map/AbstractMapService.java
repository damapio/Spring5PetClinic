package petclinic.service.map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class AbstractMapService<T,ID> {
	
	private Map<ID, T> map = new HashMap<>();
	
	Set<T> findAll() {
		return new HashSet<>(map.values());
	}
	
	T findById(ID id) {
		return map.get(id);
	}
	
	T save(ID id, T entity) {
		map.put(id,  entity);
		return entity;
	}
	
	void deleteById(ID id) {
		map.remove(id);
	}
	
	// con las lambdas hemos topado
	void delete(T object) {
		map.entrySet().removeIf(entry -> entry.getValue().equals(object));
	}

}
