package sideprojects.ndumiso.budgetapp.web.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sideprojects.ndumiso.budgetapp.domain.Budget;
import sideprojects.ndumiso.budgetapp.domain.BudgetPeriod;
import sideprojects.ndumiso.budgetapp.service.abstraction.BudgetService;

import javax.validation.Valid;
import java.util.Optional;
import java.util.Set;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * Created by Ndumiso on 1/28/2018.
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/api/v1/budgets",
        produces = {APPLICATION_JSON_VALUE})
public class BudgetResource {

    private BudgetService budgetService;

    public BudgetResource(BudgetService budgetService) {
        this.budgetService = budgetService;
    }

    @GetMapping
    public ResponseEntity<Set<Budget>> getAllBudgets() {
        Set<Budget> result = budgetService.findAll();
        return ResponseEntity.status(OK).body(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Budget> getBudgetById(@PathVariable Long id) {
        Optional<Budget> result = budgetService.findById(id);
        return result.map(budget -> ResponseEntity.status(OK).body(budget))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/filter-by/{period}")
    public ResponseEntity<Budget> getBudgetByPeriod(@PathVariable BudgetPeriod period) {
        Optional<Budget> result = budgetService.findByBudgetPeriod(period);
        return result.map(budget -> ResponseEntity.status(OK).body(budget))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<Budget> createBudget(@RequestBody @Valid Budget budget) {
        Budget result = this.budgetService.create(budget);
        return ResponseEntity.status(CREATED).body(result);
    }

    @PutMapping
    public ResponseEntity<Budget> updateBudget(@RequestBody @Valid Budget budget) {
        return ResponseEntity.ok(this.budgetService.update(budget));
    }

}
