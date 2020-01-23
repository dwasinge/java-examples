package com.derekwasinger.profile.sb.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.derekwasinger.profile.domain.Generation;
import com.derekwasinger.profile.sb.service.CrudService;

@RestController
public class GenerationResource {

	private CrudService<Generation> service;

	@Autowired
	public GenerationResource(CrudService<Generation> service) {
		this.service = service;
	}

	@PostMapping("/generations")
	public Generation post(@RequestBody Generation generation) {
		return service.create(generation);
	}

	@GetMapping("/generations")
	public List<Generation> getAll() {
		return service.getAll();
	}

	@GetMapping("/generations/{id}")
	public Generation get(@PathVariable Integer id) {
		return service.getById(id);
	}

	@PutMapping("/generations/{id}")
	public Generation put(@PathVariable Integer id, @RequestBody Generation generation) {
		return service.update(id, generation);
	}

	@DeleteMapping("/generations/{id}")
	public Generation delete(@PathVariable Integer id) {
		return service.delete(id);
	}

}
