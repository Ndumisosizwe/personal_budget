package sideprojects.ndumiso.budgetapp.repository;

import sideprojects.ndumiso.budgetapp.domain.BudgetTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Ndumiso on 1/27/2018.
 */
@Repository
public interface TransactionRepository extends JpaRepository<BudgetTransaction, Long> {
}
