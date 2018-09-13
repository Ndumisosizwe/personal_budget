import {Component, OnInit} from "@angular/core";
import {BudgetService} from "../service/budget-service";
import {Budget} from "../model/budgets/budget";
import {MenuItem} from "primeng/api";
import {NodeService} from "../service/nodeservice";
import * as _ from "underscore";

@Component({
    templateUrl: './budget-summary.component.html'
})
export class BudgetSummaryComponent implements OnInit {

    budgets: Budget[] = [];
    breadcrumbItems: MenuItem[];
    homeIcon: MenuItem;
    currentDate: Date = new Date();

    constructor(private budgetService: BudgetService, private nodeService: NodeService) {
        budgetService.getAllBudgets().subscribe((budgets: Budget[]) => {
            this.budgets = _.sortBy(budgets, "id");
        });
    }

    ngOnInit() {
        this.homeIcon = {icon: 'pi pi-home', url: '/'};
        this.breadcrumbItems = [
            {label: 'Budget summary'}
        ];
    }

    viewBudgetTransactions(budget) {
        console.log(budget);
    }

    isMonthInTheFuture(budget: Budget) {
        return (budget.id <= (this.currentDate.getMonth() + 1));
    }

}
