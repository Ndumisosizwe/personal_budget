package sideprojects.ndumiso.budgetapp.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sideprojects.ndumiso.budgetapp.domain.BudgetTransaction;
import sideprojects.ndumiso.budgetapp.repository.TransactionRepository;
import sideprojects.ndumiso.budgetapp.service.abstraction.BudgetTransactionService;
import sideprojects.ndumiso.budgetapp.web.error.exception.ApplicationException;

import java.util.List;
import java.util.Optional;

/**
 * Created by Ndumiso on 1/28/2018.
 */
@Service
@Transactional(rollbackFor = {ApplicationException.class})
public class BudgetTransactionServiceImpl implements BudgetTransactionService {

    private TransactionRepository transactionRepository;

    public BudgetTransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public List<BudgetTransaction> findAll() {
        return transactionRepository.findAll();
    }

    @Override
    public Optional<BudgetTransaction> findById(Long id) {
        return transactionRepository.findById(id);
    }

    @Override
    public BudgetTransaction create(BudgetTransaction transaction) {
        return transactionRepository.save(transaction);
    }

    @Override
    public BudgetTransaction update(BudgetTransaction transaction) {
        return transactionRepository.save(transaction);
    }

}
