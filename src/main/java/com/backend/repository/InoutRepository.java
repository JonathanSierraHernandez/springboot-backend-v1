package com.backend.repository;

import com.backend.model.Inout;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InoutRepository extends CrudRepository<Inout, Long> {}