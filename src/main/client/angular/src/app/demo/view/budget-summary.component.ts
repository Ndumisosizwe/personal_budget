import {Component} from "@angular/core";
import {BudgetService} from "../service/budget-service";
import {Budget} from "../budget.ts/budget";

@Component({
    templateUrl: './budget-summary.component.html'
})
export class BudgetSummaryComponent {

    protected budgets: Budget[] = [];

    constructor(private budgetService: BudgetService) {
        budgetService.getAllBudgets().subscribe((budgets: Budget[]) => {
            this.budgets = budgets;
            console.log(this.budgets);
        });
    }

}
