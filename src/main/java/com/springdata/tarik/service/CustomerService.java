package com.springdata.tarik.service;

import com.springdata.tarik.model.Customer;
import com.springdata.tarik.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;


    public String addCustomer(){
        Customer customer=new Customer();

        customer.setName("Fatih");
        customer.setSurName("Bayhan");

        customerRepository.save(customer);
        return "ok";
    }
}
