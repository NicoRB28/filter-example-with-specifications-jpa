package com.example.filter.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import com.example.filter.model.VipBuy;

public interface VipBuyRepository extends CrudRepository<VipBuy, Long>, JpaSpecificationExecutor<VipBuy> {

}
