package com.cg.homeloan.servicesTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.homeloan.entities.Customer;
import com.cg.homeloan.repositories.ICustomerRepository;
import com.cg.homeloan.services.ICustomerService;

@SpringBootTest
public class CustomerServiceTests {
	
	@Autowired
	ICustomerService customerService;
	
	@MockBean
	ICustomerRepository customerRepository;
	
	public static Customer customer;
	
	@BeforeAll
	public static void setup() {
		customer = new Customer();
		customer.setCustomerName("Ram");
		customer.setDateOfBirth(LocalDate.of(1999, 05, 12));
		customer.setGender("Male");
		customer.setEmailId("ram@gmail.com");
		customer.setMobileNumber("9587642315");
		customer.setNationality("Indian");
		customer.setPanNumber("123BP5L");
		customer.setAadharNumber("567845356789");
		customer.setUsername("RamSharma");
		customer.setPassword("Ram@123");
	}
	
	@Test
	@DisplayName("Positive Test case addCustomer")
	public void testaddCustomer() {
		Mockito.when(customerRepository.save(customer)).thenReturn(customer);
		assertEquals(customer, customerService.addCustomer(customer));
	}
	@Test
	public void testViewCustomer() throws Exception{

	}
	
	@Test
	public void testViewAllCustomers() throws Exception{

	}
	
	@Test
	public void testUpdateCustomer() throws Exception{

	}
	
	@Test
	public void testDeleteCustomer() throws Exception{

	}

}