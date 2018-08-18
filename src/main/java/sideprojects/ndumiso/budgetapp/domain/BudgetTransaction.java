package sideprojects.ndumiso.budgetapp.domain;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import sideprojects.ndumiso.budgetapp.domain.abstraction.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created by Ndumiso on 1/27/2018.
 */
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class BudgetTransaction extends AbstractEntity {

    @Column
    @NotNull(message = "amount is required")
    @Min(1)
    private Double amount;

    @NotNull(message = "detail is required")
    @Column
    private String detail;

    @NotNull
    @Column
    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;

    @Builder
    public BudgetTransaction(@NotNull(message = "amount is required") @Min(1) Double amount, @NotNull(message = "detail is required") String detail, @NotNull TransactionType transactionType) {
        this.amount = amount;
        this.detail = detail;
        this.transactionType = transactionType;
    }
}
