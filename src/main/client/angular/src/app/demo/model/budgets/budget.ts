import {BudgetPeriod} from './budget-period';

export interface Budget {
    id;
    createdOn;
    createdBy;
    budgetPeriod: BudgetPeriod;
    disposableCash;
    shortFall;
    transactions: any[];
}
