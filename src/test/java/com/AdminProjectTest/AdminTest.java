package com.AdminProjectTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collection;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dao.AdminService;
import com.model.Admin;

import java.util.List;
import junit.framework.Assert;
@SpringBootTest
class AdminTest {

	@Autowired
	AdminService adminservice;
	
	@Test
	void testAdd() {
		Admin admin = new Admin();
		admin.setUsername("Avinash");
		admin.setPassword("@123");
		adminservice.add(admin);
		
		Admin admin_to_be_tested = adminservice.find(admin.getId());
		Assert.assertEquals("Avinash", admin_to_be_tested.getUsername());
		Assert.assertEquals("@123", admin_to_be_tested.getPassword());
	}

	@Test
	void testFind() {
		Admin admin = new Admin();
		admin.setUsername("Praveen");
		admin.setPassword("@1234");
		adminservice.add(admin);
		
		Admin admin_to_be_tested = adminservice.find(admin.getId());
		Assert.assertEquals("Praveen", admin_to_be_tested.getUsername());
		Assert.assertEquals("@1234", admin_to_be_tested.getPassword());
     }

	@Test
	void testFindAll() {
		Admin admin = new Admin();
		admin.setUsername("Rahul");
		admin.setPassword("@12345");
		adminservice.add(admin);
		
		List<Admin> add =  adminservice.findAll();
		Assert.assertEquals("Rahul", add.get(1).getUsername());
		
	}
     		
		

	@Test
	void testUpdate() {
		Admin admin=new Admin();
		admin.setUsername("Chavan");
		admin .setPassword("#20101");
		adminservice.add(admin);
		adminservice.update(admin);

		//Admin to_be_tested = adminservice.update(admin.getAdmin());
		Assert.assertEquals(true, adminservice.update(admin));
	}

	@Test
	void testDelete() {
		adminservice.delete(2);
		Admin admin1 = adminservice.find(2);

		Assert.assertNull(admin1);
		
	}

	private Object Admin(int i) {
		// TODO Auto-generated method stub
		return null;
	}

}