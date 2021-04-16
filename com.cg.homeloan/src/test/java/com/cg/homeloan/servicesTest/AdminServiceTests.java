package com.cg.homeloan.servicesTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.cg.homeloan.entities.Admin;
import com.cg.homeloan.entities.LoanApplication;
import com.cg.homeloan.repositories.IAdminRepository;
import com.cg.homeloan.services.AdminService;
import com.cg.homeloan.services.IAdminService;

@SpringBootTest
public class AdminServiceTests {

	public static Admin admin, admin1;

	@BeforeAll
	public static void setUp() {
		admin = new Admin();
		admin1 = new Admin();
	//	admin1.setUserId(2);
		admin1.setAdminName("asd");
		admin1.setAdminContact("s7");
		admin1.setPassword("jshs@1");
		admin1.setUsername("bcx");
		admin.setUserId(1);
		admin.setAdminName("asddf");
		admin.setAdminContact("554");
		admin.setPassword("Saishf@");
		admin.setUsername("om");
	}

	@Autowired
	AdminService adminService;
	@MockBean
	IAdminRepository adminRepository;

	@Test
	@DisplayName("positive test case of add admin")
	public void testAddAdminValidTest() throws Exception {
		Mockito.when(adminRepository.save(admin)).thenReturn(admin);
		assertEquals(admin, adminService.addAdmin(admin));

	}

	@Test
	@DisplayName("negative test case of add admin")
	public void testAddAdminNotValidTest() throws Exception {
		Mockito.when(adminRepository.save(admin)).thenReturn(admin);
		assertNotEquals(admin1, adminService.addAdmin(admin));
	}

	@Test
	@DisplayName("positive test case for get admin")
	public void testGetAdminPositive() throws Exception {
		when(adminRepository.findById(1)).thenReturn(Optional.of(admin1));
		admin = adminService.getAdmin(1);
		assertEquals(admin1.toString(), admin.toString());

	}
	
	@Test
	@DisplayName("negative test case for get admin")
	public void testGetAdminNegative() throws Exception {
		when(adminRepository.findById(1)).thenReturn(Optional.of(admin1));
		admin = adminService.getAdmin(1);
		assertNotEquals(admin1.toString(), admin.toString());

	}

	@Test
	@DisplayName("positive test case of get all admin")
	public void testGetAllAdmin() throws Exception {
		adminService.getAllAdmin();
		verify(adminRepository, times(1)).findAll();
	}

	@Test
	public void testUpdateStatus() throws Exception {

	}

	@Test
	@DisplayName("Positive Test case for Validate Admin")
	public void testValidAdminPositive() {
		Admin expected = new Admin("1234567890", "admin", "12345", 1, "admin@123");
		when(adminRepository.findByUsernameAndPassword("admin@123", "12345")).thenReturn(expected);
		boolean val = adminService.isValidAdmin("admin@123", "12345");
		assertEquals(val, true);
	}

	@Test
	@DisplayName("Negative Test case for Validate Admin")
	public void testValidAdminNegative() {
		Admin expected = new Admin("1234567890", "admin", "12345", 1, "admin@123");
		when(adminRepository.findByUsernameAndPassword("admin@123", "12345")).thenReturn(expected);
		boolean val = adminService.isValidAdmin("admin@123", "12345");
		assertNotEquals(val, false);
	}

}
