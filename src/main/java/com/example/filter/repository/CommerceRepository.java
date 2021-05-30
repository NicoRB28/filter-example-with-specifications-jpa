package com.example.filter.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import com.example.filter.model.Commerce;

public interface CommerceRepository extends CrudRepository<Commerce,Long>, JpaSpecificationExecutor<Commerce> {

}
