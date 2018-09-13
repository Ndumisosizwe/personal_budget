package sideprojects.ndumiso.budgetapp.domain;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import sideprojects.ndumiso.budgetapp.domain.abstraction.AbstractEntity;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.Month;
import java.time.Year;


/**
 * <p>A budget-period encapsulates the month and year for a specific budget.</p>
 *
 * @author ndumiso.mhlongo
 */

@Entity
@Data
@EqualsAndHashCode(callSuper = true, of = {"month", "year"})
@Embeddable
@Table(name = "budget_period")
public class BudgetPeriod extends AbstractEntity {

    @NotNull
    @Column(unique = true)
    @Enumerated(EnumType.STRING)
    private Month month;

    @Min(2017)
    @Max(Year.MAX_VALUE)
    private int year;

    @Builder
    public BudgetPeriod(@NotNull Month month, @Min(2017) @Max(Year.MAX_VALUE) int year) {
        this.month = month;
        this.year = year;
    }
}
