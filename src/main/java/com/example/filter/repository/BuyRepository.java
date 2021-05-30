package com.example.filter.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import com.example.filter.model.Buy;

public interface BuyRepository  extends CrudRepository<Buy, Long>, JpaSpecificationExecutor<Buy>{

}
