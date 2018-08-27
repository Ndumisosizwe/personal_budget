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
        List<Budget> all = budgetRepository.findAll();
        all.stream().filter(b -> b.getTransactions().size() > 1)
                .forEach(Budget::calculateDisposableCash);
        return this.budgetRepository.saveAll(all);
    }

    public Optional<Budget> findById(Long id) {
        Optional<Budget> budgetOptional = budgetRepository.findById(id);
        budgetOptional.ifPresent(Budget::calculateDisposableCash);
        return budgetOptional;
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
