package com.loan.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.loan.pojo.CustomerLoan;

@Repository
public interface CustomerLoanRepository extends JpaRepository<CustomerLoan, Integer> {



	@Query(value="SELECT * FROM CUSTOMER_LOAN c where c.CUSTOMER_ID=:customerid and c.LOAN_ID=:LoanId",nativeQuery = true)
	List<CustomerLoan> findByCustomerIdAndLoanId(@Param("customerid") int customerid,@Param("LoanId") int LoanId);

	@Query(value="SELECT * FROM CUSTOMER_LOAN c where c.CUSTOMER_ID=:customerid",nativeQuery = true)
	List<CustomerLoan> findAllByCustomerId(@Param("customerid") int customerid);
}
