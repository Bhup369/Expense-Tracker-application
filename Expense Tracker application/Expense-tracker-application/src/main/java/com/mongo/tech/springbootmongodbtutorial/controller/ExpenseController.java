package com.mongo.tech.springbootmongodbtutorial.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mongo.tech.springbootmongodbtutorial.model.Expense;
import com.mongo.tech.springbootmongodbtutorial.service.ExpenseService;

@RestController
@RequestMapping("api/expense")
public class ExpenseController {
	
	
	private final ExpenseService expenseService ;
	
	
	public ExpenseController(ExpenseService expenseService) {
		
		this.expenseService = expenseService;
	}


	 @PostMapping
	 public ResponseEntity addExpense(@RequestBody Expense expense) {
	        expenseService.addExpense(expense);
	        return ResponseEntity.status(HttpStatus.CREATED).build();
	    }
	
	
	 @PutMapping
	  public ResponseEntity updateExpense(@RequestBody Expense expense) {
	        expenseService.updateExpense(expense);
	        return ResponseEntity.status(HttpStatus.OK).build();
	    }

    @GetMapping
    public ResponseEntity<List<Expense>> getAllExpenses() {
    	return ResponseEntity.ok(expenseService.getAllExpenses());    	
    }
    
    @GetMapping("/{name}")
    public ResponseEntity getExpenseByName(@PathVariable String name) {
        return ResponseEntity.ok(expenseService.getExpense(name));
    }
  
    @DeleteMapping("/{id}")
    public ResponseEntity deleteExpense(@PathVariable String id) {
        expenseService.deleteExpense(id);
        return ResponseEntity.noContent().build();
    }
  
  


}
