package com.Customer.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.client.RestTemplate;

import com.Customer.Exception.ApiRequestException;
import com.Customer.Model.Customer;
import com.Customer.Model.Order;
import com.Customer.Model.PaymentPOJO;
import com.Customer.Repository.CustomerRepository;
import com.Customer.Service.CustomerService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private CustomerService customerService;

	@Autowired
	private CustomerRepository customerRepository;

	// Creating/ADDING Customer
	@PostMapping("/addcustomer")
	@ApiOperation("adding customer details")
	public Customer saveCustomer(@RequestBody Customer customer) {
		return customerService.addCustomer(customer);

	}

	// Reading all Customer
	@GetMapping("/allcustomers")
	@ApiOperation("Reading all Customer details")
	public List<Customer> findAllCustomers() {
		return customerService.getCustomers();

	}

	// Reading Customer by ID
	@GetMapping("/allcustomers/{id}")
	@ApiOperation("Reading a particular Customer details")
	public Optional<Customer> getCustomerById(@PathVariable int id) throws ApiRequestException {
		return Optional.of(customerRepository.findById(id)
				.orElseThrow(() -> new ApiRequestException("CUSTOMER NOT FOUND WITH THIS ID ::")));
	}

	// Updating Customer Data by Id
	@PutMapping("/update/{id}")
	@ApiOperation("Updating a particular Customer details")
	public ResponseEntity<Object> updateCustomer(@PathVariable int id, @RequestBody Customer customer) {
		boolean isCustomerExist = customerRepository.existsById(id);
		if (isCustomerExist) {
			customerRepository.save(customer);
			return new ResponseEntity<Object>("user updated successfully with id " + id, HttpStatus.OK);
		} else {
			throw new ApiRequestException("CAN NOT UPDATE AS USER NOT FOUND WITH THIS ID ::");
		}

	}

	// Deleting Customer Data by Id
	@DeleteMapping("/delete/{id}")
	@ApiOperation("Deleting a particular Customer details")
	public ResponseEntity<Object> deleteCustomer(@PathVariable int id) {
		boolean isCustomerExist = customerRepository.existsById(id);
		if (isCustomerExist) {
			customerService.deleteById(id);
			return new ResponseEntity<Object>("user deleted with id" + id, HttpStatus.OK);
		} else {
			throw new ApiRequestException("CAN NOT DELETE AS USER NOT FOUND WITH THIS ID ::");
		}

	}

	/*
	 * * Below code is for the Customer for the order * Customer can AddOrder and
	 * Delete Order
	 */

	// For Adding Order

	@PostMapping("/addorder")
	@ApiOperation("adding an order based upon customer features")
	public String addOrder(@RequestBody Order order) {
		return restTemplate.postForObject("http://localhost:8083/order/addorder", order, String.class);

	}

	// for Deleting Order

	@DeleteMapping("/cancelorder/{id}")
	@ApiOperation("Deleting a particular Order details")
	public String deleteorder(@PathVariable("id") int id) {
		restTemplate.delete("http://localhost:8083/order/delete/" + id, String.class);
		return "Your Order is successfully Canceled " + id;
	}

	// for payment
	@PostMapping("/payment")
	@ApiOperation("for the payment")
	public String doPayment(@RequestBody PaymentPOJO payment) {
		return restTemplate.postForObject("http://localhost:8084/payment", payment, String.class);

	}

	// Reading All orders
	@GetMapping("/getallorders")
	@ApiOperation("Getting all the Orders")
	public String getAllOrder() {
		return restTemplate.getForObject("http://localhost:8083/order/allorders", String.class);

	}

	// Reading all the Ratings
	@GetMapping("/ratings")
	@ApiOperation("Getting all the Ratings")
	public String getAllRatings() {
		return restTemplate.getForObject("http://localhost:8081/Admin/allratings", String.class);
	}

}
