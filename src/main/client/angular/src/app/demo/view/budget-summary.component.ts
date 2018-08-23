import {Component, OnInit} from "@angular/core";
import {BudgetService} from "../service/budget-service";
import {Budget} from "../budget.ts/budget";
import {MenuItem, TreeNode} from "primeng/api";
import {NodeService} from "../service/nodeservice";

@Component({
    templateUrl: './budget-summary.component.html'
})
export class BudgetSummaryComponent implements OnInit {

    protected budgets: Budget[] = [];
    breadcrumbItems: MenuItem[];
    homeIcon: MenuItem;

    constructor(private budgetService: BudgetService, private nodeService: NodeService) {
        budgetService.getAllBudgets().subscribe((budgets: Budget[]) => {
            this.budgets = budgets;
        });
    }

    ngOnInit() {
        this.homeIcon = {icon: 'pi pi-home', url: '/'};
        this.breadcrumbItems = [
            {label: 'Budget summary'}
        ];

        this.nodeService.getFilesystem().then(files => {this.files1 = files;console.log(this.files1)});
        this.nodeService.getFilesystem().then(files => this.files2 = files);

        this.cols = [
            {field: 'name', header: 'Name'},
            {field: 'size', header: 'Size'},
            {field: 'type', header: 'Type'}
        ];
    }


    files1: TreeNode[];

    files2: TreeNode[];

    cols: any[];

}
