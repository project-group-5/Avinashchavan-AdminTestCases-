package com.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.model.Admin;
@Component
public class AdminDaoImpl implements  AdminDAO{

	
	@Autowired
	SessionFactory sessionfactory ;
	
	@Override
	public void addAdmin(AdminDAO admin) {
		Session session=sessionfactory.openSession();
		session.getTransaction().begin();
		session.save(admin);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}
	@Override
	public <Admin> Admin findadmin(int id) {
		Session session = sessionfactory.openSession();
		Admin admin = session.find(Admin.class, id);
		return admin;
	}

	@Override
	public <Admin> List<Admin>findAllAdmin(){
		Session session = sessionfactory.openSession();
		List<Admin> adminlist=session.createQuery("select i from Admin i").list();
		return adminlist;
	}
	@Override
	public <Admin> boolean updateAdmin(Admin admin) {
		// TODO Auto-generated method stub
		Session session = sessionfactory.openSession();
		session.getTransaction().begin();
		session.update(admin);
		session.flush();
		session.getTransaction().commit();
		session.close();
		return true;
	}

	@Override
	public boolean deleteAdmin(int id) {
		Session session = sessionfactory.openSession();
		Object admin = session.
		session.getTransaction().begin();
		session.delete(admin);
		session.flush();
		session.getTransaction().commit();
		session.close();
		return true;
	}
	@Override
	public <Admin> void addAdmin(Admin admin) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public <Admin> boolean updateAdmin(Admin admin) {
		return false;
	}

}