package com.Washer.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Washer {
	
	@GetMapping("/washer")
	public String getWasher() {
		return "Hello from Washer";
	}

}
