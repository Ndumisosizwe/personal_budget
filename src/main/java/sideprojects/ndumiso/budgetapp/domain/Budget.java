package sideprojects.ndumiso.budgetapp.domain;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import sideprojects.ndumiso.budgetapp.domain.abstraction.AbstractEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.Month;
import java.util.Set;

/**
 * <p>A budget encapsulates your anticipated spending for a specific month, leaving you with a rough
 * estimate of how much disposable cash you should be left with.</p>
 *
 * @author ndumiso.mhlongo
 */
@Entity
@Data
@EqualsAndHashCode(callSuper = true, of = {"budgetPeriod"})
@Table(name = "budget")
public class Budget extends AbstractEntity {

    @Column
    private Double disposableCash = 0.0;

    @JoinColumn(name = "budget_id", foreignKey = @ForeignKey)
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Transaction> transactions;

    @NotNull
    @JoinColumn(name = "period_id", foreignKey = @ForeignKey)
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private BudgetPeriod budgetPeriod;

    @Column
    private Double shortFall = 0.0;

    @Builder
    public Budget(Set<Transaction> transactions, @NotNull BudgetPeriod budgetPeriod) {
        this.transactions = transactions;
        this.budgetPeriod = budgetPeriod;
        this.calculateDisposableCash();
    }


    /**
     * Calculates and sets the disposable cash for this budget.
     */
    public void calculateDisposableCash() {
        double disposableCash = getSumOfTransactionType(TransactionType.INCOME) -
                getSumOfTransactionType(TransactionType.EXPENSE);
        //if there is more expense than income (spending more than you earn)
        if (disposableCash < 0) {
            this.shortFall = Math.abs(disposableCash);
        } else {
            this.disposableCash = disposableCash;
            this.shortFall = 0.0;
        }
    }

    private double getSumOfTransactionType(TransactionType transactionType) {
        return this.transactions.stream()
                .filter(t -> t.getTransactionType().equals(transactionType))
                .mapToDouble(Transaction::getAmount)
                .sum();
    }
}
