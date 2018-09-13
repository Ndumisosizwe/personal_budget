package sideprojects.ndumiso.budgetapp.service.abstraction;

import sideprojects.ndumiso.budgetapp.domain.Budget;
import sideprojects.ndumiso.budgetapp.domain.BudgetPeriod;
import sideprojects.ndumiso.budgetapp.service.abstraction.AbstractCrudService;

import java.time.Month;
import java.util.Optional;

/**
 * Created by Ndumiso on 1/28/2018.
 */
public interface BudgetService extends AbstractCrudService<Budget> {

    Optional<Budget> findByBudgetPeriod(BudgetPeriod budgetPeriod);

}
