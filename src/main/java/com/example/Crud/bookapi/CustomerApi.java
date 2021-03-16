package com.example.Crud.bookapi;

import com.example.Crud.bookdao.entity.Customer;
import com.example.Crud.bookmanager.CustomerManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/customers")
public class CustomerApi {
    private CustomerManager customerManager;

    @Autowired
    public CustomerApi(CustomerManager customerManager) {
        this.customerManager = customerManager;
    }

    @GetMapping("/allcustomers")
    public Iterable<Customer> getAll(){
        return customerManager.findCustomerAll();
    }

    @GetMapping
    public Optional<Customer> getById(@RequestParam Long index){
        return customerManager.findCustomerById(index);
    }

    @PostMapping
    public Customer addCustomer(@RequestBody Customer customer){
        return customerManager.saveCustomer(customer);
    }

    @PutMapping
    public Customer updateGame(@RequestBody Customer customer){
        return customerManager.saveCustomer(customer);
    }

    @DeleteMapping
    public void deleteGame(@RequestParam Long index){
        customerManager.deleteById(index);
    }
}
