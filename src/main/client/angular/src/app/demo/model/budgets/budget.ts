import {BudgetPeriod} from "./budget-period";

export interface Budget {
    id;
    createdOn;
    createdBy;
    period:BudgetPeriod;
    disposableCash;
    shortFall;
    transactions:any[];
}
