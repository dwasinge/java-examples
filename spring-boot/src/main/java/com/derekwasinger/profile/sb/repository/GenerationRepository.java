package com.derekwasinger.profile.sb.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.derekwasinger.profile.domain.Generation;

@Repository
public interface GenerationRepository extends CrudRepository<Generation, Integer> {

}
