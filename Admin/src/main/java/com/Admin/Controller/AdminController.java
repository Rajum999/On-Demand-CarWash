package com.Admin.Controller;

import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.Admin.Exception.ApiRequestException;
import com.Admin.Models.Admin;
import com.Admin.Models.Customer;
import com.Admin.Models.Order;
import com.Admin.Models.Ratings;
import com.Admin.Models.WashPacks;
import com.Admin.Models.Washer;
import com.Admin.Service.WashPackService;
import com.Admin.repository.AdminRepository;
import com.Admin.repository.CustomerRepository;
import com.Admin.repository.RatingRepository;
import com.Admin.repository.WashPackRepository;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/Admin")
public class AdminController {

	@Autowired
	private WashPackRepository washPackRepository;

	@Autowired
	private AdminRepository adminRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private RatingRepository ratingRepository;

	// Adding Admin
	@PostMapping("/addadmin")
	@ApiOperation("Adding Admin Details")
	public String saveAdmin(@RequestBody Admin admin) {
		adminRepository.save(admin);
		return "Admin Saved Successfully with id:" + admin.getaId();

	}

	// Reading All admin
	@GetMapping("/alladmins")
	@ApiOperation("Reading/Retrieving Admin Details")
	public List<Admin> getallAdmins() {
		return adminRepository.findAll();

	}

	// Reading Admin by ID
	@GetMapping("/alladmins/{id}")
	@ApiOperation("Reading Admin deatils by id")
	public Optional<Admin> getadminbyId(@PathVariable int id) {
		return adminRepository.findById(id);

	}

	@PutMapping("/update/{id}")
	@ApiOperation("Updating a particular Admin details")
	public ResponseEntity<Object> updateAdmin(@PathVariable int id, @RequestBody Admin admin) {
		boolean isAdminExist = adminRepository.existsById(id);
		if (isAdminExist) {
			adminRepository.save(admin);
			return new ResponseEntity<Object>("user updated successfully with id " + id, HttpStatus.OK);
		} else {
			throw new ApiRequestException("CAN NOT UPDATE AS Admin NOT FOUND WITH THIS ID ::");
		}

	}

	@PutMapping("/delete/{id}")
	@ApiOperation("delete a particular Admin details")
	public ResponseEntity<Object> deleteAdmin(@PathVariable int id, @RequestBody Admin admin) {
		boolean isAdminExist = adminRepository.existsById(id);
		if (isAdminExist) {
			adminRepository.delete(admin);
			;
			return new ResponseEntity<Object>("user deleted successfully with id " + id, HttpStatus.OK);
		} else {
			throw new ApiRequestException("CAN NOT delete AS Admin NOT FOUND WITH THIS ID ::");
		}

	}

	// Reading orders By
	@GetMapping("/getallorders/{id}")
	@ApiOperation("Reading/retrieving the Orders by Id")
	public Order getOrderById(@PathVariable("id") int id) {
		return restTemplate.getForObject("http://localhost:8083/order/orders/" + id, Order.class);

	}

	// Reading All orders
	@GetMapping("/getallorders")
	@ApiOperation("Reading/retrieving all the Orders")
	public String getallOrder() {
		return restTemplate.getForObject("http://localhost:8083/order/allorders", String.class);

	}

	// Adding Washer
	@PostMapping("/addwasher")
	@ApiOperation("Adding the Washer details")
	public String addWasher(@RequestBody Washer washer) {
		return restTemplate.postForObject("http://localhost:8085/washer/addwasher", washer, String.class);
	}

	// adding the washerpacks
	@PostMapping("/addpack")
	@ApiOperation("Adding the Washpacks")
	public String savepack(@RequestBody WashPacks pack) {

		washPackRepository.save(pack);
		return " Pack saved successfully with id :" + pack.getId();
	}

	// getting the packs
	@GetMapping("/allpacks")
	@ApiOperation("Reading/retrieving all the Washpack details")
	public List<WashPacks> getpack() {
		return washPackRepository.findAll();

	}

	// updating the washpacks

	@PutMapping("/updateWashPack/{id}")

	@ApiOperation("Updating a washpack details")
	public ResponseEntity<Object> updateWashPack(@PathVariable int id, @RequestBody WashPacks washpacks) {
		boolean isWashPackExist = washPackRepository.existsById(id);
		if (isWashPackExist) {
			washPackRepository.save(washpacks);
			return new ResponseEntity<Object>("WashPack updated successfully with id " + id, HttpStatus.OK);
		} else {
			throw new ApiRequestException("CAN NOT UPDATE AS WashPack NOT FOUND WITH THIS ID ::");
		}

	}

	// deleting the Washpacks

	@PutMapping("/deleteWashPack/{id}")

	@ApiOperation("delete a particular washpack details")
	public ResponseEntity<Object> deleteWashPack(@PathVariable int id, @RequestBody WashPacks washpacks) {
		boolean isWashPackExist = washPackRepository.existsById(id);
		if (isWashPackExist) {
			washPackRepository.delete(washpacks);
			;
			return new ResponseEntity<Object>("WashPack deleted successfully with id " + id, HttpStatus.OK);
		} else {
			throw new ApiRequestException("CAN NOT delete AS WashPack NOT FOUND WITH THIS ID ::");
		}

	}

	// Adding adding the ratings
	@PostMapping("/addrating")
	@ApiOperation("Adding the ratings")
	public String saverating(@RequestBody Ratings rating) {

		ratingRepository.save(rating);
		return " Thanks for Your Valuable feedback";
	}

	// getting all the ratings
	@GetMapping("/allratings")
	@ApiOperation("Reading/retrieving all the Ratings")
	public List<Ratings> getuser() {

		return ratingRepository.findAll();
	}

	// Retrieving the Customer Details
	@GetMapping("/getcustomers")
	@ApiOperation("Reading/retrieving all the Customers")
	public String getallCustomers() {
		return restTemplate.getForObject("http://localhost:8082/customer/allcustomers", String.class);

	}

	// Retrieving the Washer Details
	@GetMapping("/getwashers")
	@ApiOperation("Reading/retrieving all the Washers")
	public String getallWashers() {
		return restTemplate.getForObject("http://localhost:8085/washer/allwashers", String.class);

	}

	/*
	 * @PostMapping("/addcustomer") public String addcustomer(@RequestBody Customer
	 * customer) { return
	 * restTemplate.postForObject("http://localhost:8082/customer/addcustomer",
	 * customer, String.class); }
	 */
	
	/*
	 * @PutMapping("/updateCustomer/{id}")
	 * 
	 * @ApiOperation("Upadating a partucular Customer details") public Customer
	 * updateCustomer(@PathVariable int id, @RequestBody Customer customer){
	 * 
	 * return restTemplate.put("http://localhost:8082/customer/update",List.class);
	 * }
	 */
}
