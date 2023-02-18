package com.clp.repository;

import java.util.List;
import java.util.function.Predicate;

public interface IRepository<TEntity> {
	List<TEntity> get(Predicate<TEntity> filter);

	TEntity find(Predicate<TEntity> predicate);

	void insert(TEntity entity);

	void delete(TEntity entityToDelete);
}