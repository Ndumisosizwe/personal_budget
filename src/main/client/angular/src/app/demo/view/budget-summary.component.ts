import {Component, OnInit} from "@angular/core";
import {BudgetService} from "../service/budget-service";
import {Budget} from "../budget.ts/budget";
import {MenuItem} from "primeng/api";

@Component({
    templateUrl: './budget-summary.component.html'
})
export class BudgetSummaryComponent implements OnInit {

    protected budgets: Budget[] = [];
    breadcrumbItems: MenuItem[];
    homeIcon: MenuItem;

    constructor(private budgetService: BudgetService) {
        budgetService.getAllBudgets().subscribe((budgets: Budget[]) => {
            this.budgets = budgets;
            console.log(this.budgets);
        });
    }

    ngOnInit() {
        this.homeIcon = {icon: 'pi pi-home'};
        this.breadcrumbItems = [
            {label: 'Categories'},
            {label: 'Sports'},
            {label: 'Football'},
            {label: 'Countries'},
            {label: 'Spain'},
            {label: 'F.C. Barcelona'},
            {label: 'Squad'},
            {label: 'Lionel Messi', url: 'https://en.wikipedia.org/wiki/Lionel_Messi'}
        ];
    }

}
