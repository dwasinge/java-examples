package com.derekwasinger.profile.sb.service;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface CrudService<T> {

	List<T> getAll();

	T getById(Integer id);

	T create(T entity);

	T update(Integer id, T entity);

	T delete(Integer id);

}
