package com.clp.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Repository<TEntity> implements IRepository<TEntity> {
    private List<TEntity> entities;

    public Repository() {
        entities = new ArrayList<>();
    }

    @Override
    public List<TEntity> get(Predicate<TEntity> filter) {
        List<TEntity> result = new ArrayList<>(entities);
        if (filter != null) {
            result.removeIf(filter.negate());
        }
        return result;
    }

    @Override
    public TEntity find(Predicate<TEntity> predicate) {
        return entities.stream().filter(predicate).findFirst().orElse(null);
    }

    @Override
    public boolean insert(TEntity entity) {
    	
    	if( entity == null) {
    		return false;
    	}
        entities.add(entity);
        return true;
    }

    @Override
    public void delete(TEntity entityToDelete) {
        entities.remove(entityToDelete);
    }
}
