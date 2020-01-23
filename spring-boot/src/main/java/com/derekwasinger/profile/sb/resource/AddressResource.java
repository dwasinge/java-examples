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

import com.derekwasinger.profile.domain.Address;
import com.derekwasinger.profile.sb.service.CrudService;

@RestController
public class AddressResource {

	private CrudService<Address> service;

	@Autowired
	public AddressResource(CrudService<Address> service) {
		this.service = service;
	}

	@PostMapping("/addresses")
	public Address post(@RequestBody Address address) {
		return service.create(address);
	}

	@GetMapping("/addresses")
	public List<Address> getAll() {
		return service.getAll();
	}

	@GetMapping("/addresses/{id}")
	public Address get(@PathVariable Integer id) {
		return service.getById(id);
	}

	@PutMapping("/addresses/{id}")
	public Address put(@PathVariable Integer id, @RequestBody Address address) {
		return service.update(id, address);
	}

	@DeleteMapping("/addresses/{id}")
	public Address delete(@PathVariable Integer id) {
		return service.delete(id);
	}

}
