import {RouterModule, Routes} from "@angular/router";
import {ModuleWithProviders} from "@angular/core";
import {SampleDemoComponent} from "./demo/view/sampledemo.component";
import {BudgetSummaryComponent} from "./demo/view/budget-summary.component";
import {ChartsDemoComponent} from "./demo/view/chartsdemo.component";

export const routes: Routes = [
    { path: '', component: SampleDemoComponent },
    { path: 'budget-summary', component: BudgetSummaryComponent },
    { path: 'reports', component: ChartsDemoComponent },

];

export const AppRoutes: ModuleWithProviders = RouterModule.forRoot(routes);
