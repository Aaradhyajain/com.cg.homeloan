package com.cg.homeloan;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.cg.homeloan.entities.Customer;
import com.cg.homeloan.repositories.ICustomerRepository;
import com.cg.homeloan.services.ICustomerService;

@SpringBootTest
class CustomerServiceTest {

	public static Customer customer, customer1;

	@BeforeAll
	public static void setup() {
		customer = new Customer();
		customer.setUserId(1);
		customer.setCustomerName("Sita");
		customer.setDateOfBirth(LocalDate.now());
		customer.setGender("female");
		customer.setEmailId("sita@gmail.com");
		customer.setMobileNumber("7898789887");
		customer.setNationality("Indian");
		customer.setPanNumber("213BP2P");
		customer.setAadharNumber("528545691236");
		customer.setUsername("Sita");
		customer.setPassword("1234");
		
		customer1 = new Customer();
		customer1.setUserId(2);
		customer1.setCustomerName("Sita");
		customer1.setDateOfBirth(LocalDate.now());
		customer1.setGender("female");
		customer1.setEmailId("sita@gmail.com");
		customer1.setMobileNumber("7898789887");
		customer1.setNationality("Indian");
		customer1.setPanNumber("213BP2P");
		customer1.setAadharNumber("528545691236");
		customer1.setUsername("Sita");
		customer1.setPassword("1234");
	}

	@Autowired
	ICustomerService customerService;

	@MockBean
	ICustomerRepository customerRepository;

	@Test
	@DisplayName("Positive Test case addCustomer")
	void testAddCustomePositive() {
		when(customerRepository.save(customer)).thenReturn(customer);
		assertEquals(customer, customerService.addCustomer(customer));
	}

	@Test
	@DisplayName("negative test case addCustomer")
	void testAddCustomerNegative() {
		when(customerRepository.save(customer)).thenReturn(customer);
		assertNotEquals(customer1, customerService.addCustomer(customer));
	}

	@Test
	@DisplayName("Positive test case getCustomer")
	void testGetCustomerPositive() throws Exception {
		when(customerRepository.findById(1)).thenReturn(Optional.of(customer));
		assertEquals(customer, customerService.getCustomer(1));
	}

	@Test
	@DisplayName("negative test case getCustomer")
	void testGetCustomerNegative() throws Exception {
		when(customerRepository.findById(1)).thenReturn(Optional.of(customer));
		assertNotEquals(customer1, customerService.getCustomer(1));
	}

	@Test
	@DisplayName("positive get all customer")
	void testGetAllCustomerPositive() throws Exception {
		List<Customer> list = new ArrayList<>();
		list.add(customer);
		list.add(customer1);
		customerService.getAllCustomers();
		when(customerRepository.findAll()).thenReturn(list);
		assertEquals(list.size(), customerService.getAllCustomers().size());
	}

	@Test
	@DisplayName("negative get all customer")
	void testGetAllCustomerNegative() throws Exception {
		List<Customer> list = new ArrayList<>();
		list.add(customer);
		list.add(customer1);
		customerService.getAllCustomers();
		when(customerRepository.findAll()).thenReturn(list);
		assertNotEquals(3, customerService.getAllCustomers().size());
	}

	@Test
	@DisplayName("positive update customer")
	void testUpdateCustomerPositive() throws Exception {

	}

	@Test
	@DisplayName("negative update customer")
	void testUpdateCustomerNegative() throws Exception {

	}

	@Test
	@DisplayName("positive delete customer")
	void testDeleteCustomerPositive() throws Exception {

	}

	@Test
	@DisplayName("negative delete customer")
	void testDeleteCustomerNegative() throws Exception {

	}

}
