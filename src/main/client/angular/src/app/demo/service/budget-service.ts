import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Observable} from 'rxjs/index';

@Injectable()
export class BudgetService {
    constructor(private http: HttpClient) {
    }

    public getAllBudgets(): Observable<any> {
        return this.http.get<any>('http://localhost:8081/budgetapp/api/v1/budgets');
    }
}
