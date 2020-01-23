package com.derekwasinger.profile.sb.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.derekwasinger.profile.domain.Address;

@Repository
public interface AddressRepository extends CrudRepository<Address, Integer> {

}
