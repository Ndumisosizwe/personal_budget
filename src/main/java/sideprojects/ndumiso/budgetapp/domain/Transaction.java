package sideprojects.ndumiso.budgetapp.domain;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import sideprojects.ndumiso.budgetapp.domain.abstraction.AbstractEntity;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * <p>Created by Ndumiso on 1/27/2018.<p/>
 */
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "transaction")
public class Transaction extends AbstractEntity {

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
    public Transaction(@NotNull(message = "amount is required") @Min(1) Double amount, @NotNull(message = "detail is required") String detail, @NotNull TransactionType transactionType) {
        this.amount = amount;
        this.detail = detail;
        this.transactionType = transactionType;
    }
}
