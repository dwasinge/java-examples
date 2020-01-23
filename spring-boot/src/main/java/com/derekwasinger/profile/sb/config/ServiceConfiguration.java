package com.derekwasinger.profile.sb.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.derekwasinger.profile.domain.Address;
import com.derekwasinger.profile.domain.Generation;
import com.derekwasinger.profile.domain.Profile;
import com.derekwasinger.profile.sb.repository.AddressRepository;
import com.derekwasinger.profile.sb.repository.GenerationRepository;
import com.derekwasinger.profile.sb.repository.ProfileRepository;
import com.derekwasinger.profile.sb.service.CrudService;
import com.derekwasinger.profile.sb.service.SimpleCrudService;

@Configuration
public class ServiceConfiguration {

	@Bean
	@Autowired
	public CrudService<Address> addressService(AddressRepository repository) {
		return new SimpleCrudService<Address>(repository);
	}

	@Bean
	@Autowired
	public CrudService<Generation> generationService(GenerationRepository repository) {
		return new SimpleCrudService<Generation>(repository);
	}

	@Bean
	@Autowired
	public CrudService<Profile> profileService(ProfileRepository repository) {
		return new SimpleCrudService<Profile>(repository);
	}

}
