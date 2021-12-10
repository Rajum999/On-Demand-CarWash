package com.Payment.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Payment.Model.PaymentPOJO;
import com.Payment.Service.PaymentService;

@RestController
public class PaymentController {
	
	@Autowired
	public PaymentService paymentService;
	
	@PostMapping("/payment")
	public PaymentPOJO doPayment(@RequestBody PaymentPOJO payment) {
		return paymentService.doPay(payment);
		
	}

}
