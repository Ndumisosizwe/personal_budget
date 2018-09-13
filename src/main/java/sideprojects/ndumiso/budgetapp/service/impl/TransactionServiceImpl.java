package sideprojects.ndumiso.budgetapp.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sideprojects.ndumiso.budgetapp.domain.Budget;
import sideprojects.ndumiso.budgetapp.domain.Transaction;
import sideprojects.ndumiso.budgetapp.repository.TransactionRepository;
import sideprojects.ndumiso.budgetapp.service.abstraction.TransactionService;
import sideprojects.ndumiso.budgetapp.web.error.exception.ApplicationException;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * Created by Ndumiso on 1/28/2018.
 */
@Service
@Transactional(rollbackFor = {ApplicationException.class})
public class TransactionServiceImpl implements TransactionService {

    private TransactionRepository transactionRepository;

    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public Set<Transaction> findAll() {
        return new HashSet<>(transactionRepository.findAll());
    }

    @Override
    public Optional<Transaction> findById(Long id) {
        return transactionRepository.findById(id);
    }

    @Override
    public Transaction create(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    @Override
    public Transaction update(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

}
