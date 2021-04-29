package com.cts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.models.CollateralRisk;

@Repository
public interface CollateralRiskRepository extends JpaRepository<CollateralRisk, Integer> {

}
