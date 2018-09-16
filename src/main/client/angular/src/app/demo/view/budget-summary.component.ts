import {Component, OnInit} from "@angular/core";
import {BudgetService} from "../service/budget-service";
import {Budget} from "../model/budgets/budget";
import {MenuItem} from "primeng/api";
import {NodeService} from "../service/nodeservice";
import * as _ from "underscore";
import {NgxSpinnerService} from 'ngx-spinner';
import {MessageService} from "primeng/components/common/messageservice";
import {DatePipe} from "@angular/common";

@Component({
    templateUrl: './budget-summary.component.html'
})
export class BudgetSummaryComponent implements OnInit {

    budgets: Budget[] = [];
    breadcrumbItems: MenuItem[];
    homeIcon: MenuItem;
    currentDate: Date = new Date();
    displayDialog: boolean = false;
    index: number = -1;
    selectedBudget: Budget;
    newTransPanelCollapsed: boolean = true;

    constructor(private budgetService: BudgetService, private nodeService: NodeService,
                private spinner: NgxSpinnerService, private messageService: MessageService, private datePipe: DatePipe) {

    }

    ngOnInit() {
        this.spinner.show();
        this.budgetService.getAllBudgets().subscribe((budgets: Budget[]) => {
            this.budgets = _.sortBy(budgets, "id");
            this.spinner.hide();
        });
        this.homeIcon = {icon: 'pi pi-home', url: '/'};
        this.breadcrumbItems = [
            {label: 'Budget summary'}
        ];
    }

    viewBudgetTransactions(budget: Budget) {
        this.selectedBudget = budget;
        this.spinner.show();
        setTimeout(() => {
            this.spinner.hide();
            this.displayDialog = true;
        }, 1200);
        console.log(budget);
    }

    isMonthInTheFuture(budget: Budget) {
        return (budget.id <= (this.currentDate.getMonth() + 1));
    }

    onTabClose(event) {
        this.messageService.add({severity: 'info', summary: 'Tab Closed', detail: 'Index: ' + event.index})
    }

    onTabOpen(event) {
        this.messageService.add({severity: 'info', summary: 'Tab Expanded', detail: 'Index: ' + event.index});
    }

    transformDate(date): string {
        return this.datePipe.transform(date, 'MMMM - dd');
    }

    addNewTransaction(){
        console.log('adding new transaction to budget ', this.selectedBudget);
        this.newTransPanelCollapsed = !this.newTransPanelCollapsed;
    }

    saveNewTransaction(){
        this.spinner.show();
        setTimeout(() => {
            this.spinner.hide();
            if(!this.newTransPanelCollapsed)
                this.newTransPanelCollapsed = true;
        }, 1200);
    }


}
