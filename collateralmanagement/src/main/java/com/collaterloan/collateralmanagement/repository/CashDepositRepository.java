package com.collaterloan.collateralmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.collaterloan.collateralmanagement.Entity.CashDeposits;

@Repository
public interface CashDepositRepository extends JpaRepository<CashDeposits,Integer> {

}
