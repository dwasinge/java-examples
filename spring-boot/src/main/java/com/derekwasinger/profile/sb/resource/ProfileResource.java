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

import com.derekwasinger.profile.domain.Profile;
import com.derekwasinger.profile.sb.service.CrudService;

@RestController
public class ProfileResource {

	private CrudService<Profile> service;

	@Autowired
	public ProfileResource(CrudService<Profile> service) {
		this.service = service;
	}

	@GetMapping("/profiles")
	public List<Profile> getAll() {
		return service.getAll();
	}

	@PostMapping("/profiles")
	public Profile post(@RequestBody Profile profile) {
		return service.create(profile);
	}

	@GetMapping("/profiles/{id}")
	public Profile get(@PathVariable Integer id) {
		return service.getById(id);
	}

	@PutMapping("/profiles/{id}")
	public Profile put(@PathVariable Integer id, @RequestBody Profile profile) {
		return service.update(id, profile);
	}

	@DeleteMapping("/profiles/{id}")
	public Profile delete(@PathVariable Integer id) {
		return service.delete(id);
	}

}
