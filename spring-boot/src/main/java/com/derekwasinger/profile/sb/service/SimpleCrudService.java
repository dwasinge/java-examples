package com.derekwasinger.profile.sb.service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.derekwasinger.profile.sb.exception.AlreadyExistsException;
import com.derekwasinger.profile.sb.exception.NotFoundException;

import io.micrometer.core.instrument.config.InvalidConfigurationException;
import lombok.Setter;

public class SimpleCrudService<T> implements CrudService<T> {

	@Setter
	private String idFieldName = "id";	
	private CrudRepository<T, Integer> repository;

	public SimpleCrudService(CrudRepository<T, Integer> repository) {
		this.repository = repository;
	}

	@Override
	public List<T> getAll() {

		List<T> resultList = new ArrayList<>();
		Iterable<T> iterable = repository.findAll();
		iterable.forEach(resultList::add);

		return resultList;

	}

	@Override
	public T getById(Integer id) {

		// throw not found if id is null
		if (null == id) {
			throw new NotFoundException("no id supplied so no generation resource found.");
		}

		Optional<T> optional = repository.findById(id);
		if (!optional.isPresent()) {
			throw new NotFoundException("No generation resource found with id '" + id + "'");
		}

		return optional.get();

	}

	@Override
	public T create(T entity) {

		Integer id = getValueOfEntityId(entity);

		try {
			// check if it already exists
			getById(id);
		} catch (NotFoundException e) {
			// create new resource
			return repository.save(entity);
		}

		// throw exception if already exists
		throw new AlreadyExistsException("generation with id '" + id + "' already exists.");

	}

	@Override
	public T update(Integer id, T entity) {

		// make sure it already exists
		getById(id);

		// set id on generation
		setValueOfEntityId(id, entity);

		// save the resource
		return repository.save(entity);

	}

	@Override
	public T delete(Integer id) {

		// make sure it already exists
		T entity = getById(id);

		// delete resource
		repository.delete(entity);

		return entity;

	}

	private Integer getValueOfEntityId(T entity) {

		try {
			Field f = entity.getClass().getDeclaredField(idFieldName);
			f.setAccessible(true);
			return (Integer) f.get(entity);
		} catch (Exception e) {
			throw new InvalidConfigurationException("failed to get value of id field '" + idFieldName + "'");
		}

	}

	private void setValueOfEntityId(Integer id, T entity) {

		try {
			Field f = entity.getClass().getDeclaredField(idFieldName);
			f.setAccessible(true);
			f.set(entity, id);
		} catch (Exception e) {
			throw new InvalidConfigurationException("failed to set value of id field '" + idFieldName + "'");
		}

	}

}
