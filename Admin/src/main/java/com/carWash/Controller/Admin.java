package com.carWash.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/A1")
public class Admin {
	
	@GetMapping("/admin")
	public String getAdmin(){
		return "Hello from the getAdmin";
	}

}
