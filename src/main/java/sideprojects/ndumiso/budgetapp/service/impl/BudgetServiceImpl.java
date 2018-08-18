package sideprojects.ndumiso.budgetapp.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sideprojects.ndumiso.budgetapp.domain.Budget;
import sideprojects.ndumiso.budgetapp.repository.BudgetRepository;
import sideprojects.ndumiso.budgetapp.service.abstraction.BudgetService;
import sideprojects.ndumiso.budgetapp.web.error.exception.ApplicationException;

import javax.transaction.TransactionScoped;
import java.time.Month;
import java.util.List;
import java.util.Optional;

/**
 * Created by Ndumiso on 1/28/2018.
 */
@Service
@Transactional(rollbackFor = {ApplicationException.class})
public class BudgetServiceImpl implements BudgetService {

    private final String ERROR_MESSAGE_TRANSACTIONS_MIN_COUNT = "A budget cannot exist without transactions.";
    private BudgetRepository budgetRepository;

    public BudgetServiceImpl(BudgetRepository budgetRepository) {
        this.budgetRepository = budgetRepository;
    }

    @Override
    public List<Budget> findAll() {
        return budgetRepository.findAll();
    }

    public Optional<Budget> findById(Long id) {
        return budgetRepository.findById(id);
    }

    @Override
    public Budget create(Budget entity) {
        if (entity.getTransactions().size() < 1)
            throw new ApplicationException(ERROR_MESSAGE_TRANSACTIONS_MIN_COUNT);
        entity.calculateDisposableCash();
        return budgetRepository.save(entity);
    }

    @Override
    public Budget update(Budget entity) {
        if (entity.getTransactions().size() < 1)
            throw new ApplicationException(ERROR_MESSAGE_TRANSACTIONS_MIN_COUNT);
        entity.calculateDisposableCash();
        return budgetRepository.save(entity);
    }

    @Override
    public Optional<Budget> findByMonth(Month month) {
        return Optional.ofNullable(budgetRepository.findByMonth(month));
    }
}
