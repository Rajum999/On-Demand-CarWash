package com.Customer.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/C1")
public class Customer {
	
	@GetMapping("/customer")
	public String getCustomer() {
		return "Hello from Customer";
	}

}
