package com.example.Crud.bookmanager;

import com.example.Crud.bookdao.CustomerRepo;
import com.example.Crud.bookdao.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerManager {
    private CustomerRepo customerRepo;

    @Autowired
    public CustomerManager(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    public Optional<Customer> findCustomerById(Long id){
        return customerRepo.findById(id);
    }

    public Iterable<Customer> findCustomerAll(){
        return customerRepo.findAll();
    }

    public Customer saveCustomer(Customer customer){
        return customerRepo.save(customer);
    }

    public void deleteById(Long id){
        customerRepo.deleteById(id);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void fill3DB() {
        saveCustomer(new Customer(1L, "John", "John", "Thinking in Java", null));
        saveCustomer(new Customer(2L, "James", "Collins", null, "God of war"));
    }
}
