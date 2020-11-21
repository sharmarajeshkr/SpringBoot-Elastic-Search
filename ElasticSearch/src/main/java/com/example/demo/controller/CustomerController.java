package com.example.demo.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.*;
import com.example.demo.model.Customer;
import com.example.demo.model.repository.CustomerDAO;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	
	private CustomerDAO customerDao;
	
	public CustomerController(CustomerDAO custDao) {
		this.customerDao = custDao;
	}
	
	@PostMapping
    public Customer insertBook(@RequestBody Customer cust) throws Exception{
        return customerDao.insertBook(cust);
    }

    @GetMapping("/{id}")
    public Map<String, Object> getCustomerById(@PathVariable String id){
        return customerDao.getCustomerById(id);
    }

    @PutMapping("/{id}")
    public Map<String, Object> updateCustomerById(@RequestBody Customer cust, @PathVariable String id){
        return customerDao.updateCustomerById(id, cust);
    }

    @DeleteMapping("/{id}")
    public void deleteBookById(@PathVariable String id){
    	customerDao.deleteCustomerById(id);
    }
	
	

}
