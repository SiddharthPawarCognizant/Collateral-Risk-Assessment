package com.collaterloan.collateralmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.collaterloan.collateralmanagement.Entity.Real_Estate;

@Repository
public interface RealEstateRepository extends JpaRepository<Real_Estate, Integer> {

}
