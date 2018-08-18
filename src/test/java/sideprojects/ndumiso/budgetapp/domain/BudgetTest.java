package sideprojects.ndumiso.budgetapp.domain;

import org.junit.Test;

import java.time.Month;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class BudgetTest {

    @Test
    public void shouldCalculateCorrectDisposableCash() throws Exception {
        Budget budget = new Budget(Month.JANUARY, this.getMockSetOfTransactions(5));
        assertThat(budget.getDisposableCash()).isEqualTo(2.0);
    }

    @Test
    public void shouldReturnTheCorrectShortFallAmount() {
        Budget budget = new Budget(Month.JANUARY, this.getMockSetOfTransactions(2));
        assertThat(budget.getShortFall()).isEqualTo(1);

    }


    private Set<BudgetTransaction> getMockSetOfTransactions(double incomeAmount) {
        return new HashSet<>(Arrays.asList(
                BudgetTransaction.builder()
                        .amount(1.0)
                        .detail("Loan payment")
                        .transactionType(TransactionType.EXPENSE)
                        .build(),
                BudgetTransaction.builder()
                        .amount(2.0)
                        .detail("Loan Payment")
                        .transactionType(TransactionType.EXPENSE)
                        .build(),
                BudgetTransaction.builder()
                        .amount(incomeAmount)
                        .transactionType(TransactionType.INCOME)
                        .detail("Salary")
                        .build()
        ));
    }

}