package sideprojects.ndumiso.budgetapp.repository;

import sideprojects.ndumiso.budgetapp.domain.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Ndumiso on 1/27/2018.
 */
@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
