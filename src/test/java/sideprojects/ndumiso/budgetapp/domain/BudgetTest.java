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
        Budget budget = new Budget(this.getMockSetOfTransactions(5), new BudgetPeriod(Month.JANUARY, 2018));
        assertThat(budget.getDisposableCash()).isEqualTo(2.0);
    }

    @Test
    public void shouldReturnTheCorrectShortFallAmount() {
        Budget budget = new Budget(this.getMockSetOfTransactions(2), new BudgetPeriod(Month.JANUARY, 2018));
        assertThat(budget.getShortFall()).isEqualTo(1);

    }


    private Set<Transaction> getMockSetOfTransactions(double incomeAmount) {
        return new HashSet<>(Arrays.asList(
                Transaction.builder()
                        .amount(1.0)
                        .detail("Loan payment")
                        .transactionType(TransactionType.EXPENSE)
                        .build(),
                Transaction.builder()
                        .amount(2.0)
                        .detail("Loan Payment")
                        .transactionType(TransactionType.EXPENSE)
                        .build(),
                Transaction.builder()
                        .amount(incomeAmount)
                        .transactionType(TransactionType.INCOME)
                        .detail("Salary")
                        .build()
        ));
    }

}