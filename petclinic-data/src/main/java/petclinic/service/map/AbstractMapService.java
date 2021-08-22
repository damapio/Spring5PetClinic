package petclinic.service.map;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import petclinic.model.BaseEntity;

public abstract class AbstractMapService<T extends BaseEntity,ID extends Long> {
	
	private Map<Long, T> map = new HashMap<>();
	
	Set<T> findAll() {
		return new HashSet<>(map.values());
	}
	
	T findById(ID id) {
		return map.get(id);
	}
	
	T save(T entity) {
		if (null != entity) {
			if (null == entity.getId()) {
				entity.setId(getNextId());
			}
			map.put(entity.getId(),  entity);
		}
		
		return entity;
	}
	
	private Long getNextId() {
		Long baseId = 0L;
		if (!map.isEmpty()) {
			baseId = Collections.max(map.keySet());
		}
		return baseId + 1;
	}
	
	void deleteById(ID id) {
		map.remove(id);
	}
	
	// con las lambdas hemos topado
	void delete(T object) {
		map.entrySet().removeIf(entry -> entry.getValue().equals(object));
	}


}
