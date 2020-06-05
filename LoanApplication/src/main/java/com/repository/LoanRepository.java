package com.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.vo.Loan;



public interface LoanRepository extends CrudRepository<Loan, Long> {
    @Modifying
    @Transactional
	@Query(value = "update Loan l set l.status=?2 where l.id=?1", nativeQuery = true)
	void updateLoanStatus(@Param("id") long id, @Param("status") String status);

}
