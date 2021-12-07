package com.Order.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Ord")
public class OrderTest {
	
	@GetMapping("/order")
	public String getOrder() {
		return "Hello From getOrder";
	}

}
