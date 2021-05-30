package com.example.filter.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import com.example.filter.model.NormalBuy;

public interface NormalBuyRepository extends CrudRepository<NormalBuy, Long>, JpaSpecificationExecutor<NormalBuy>{

}
