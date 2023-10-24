package com.jsp.vehicle.registration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Driver {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("gauri");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		
		Vehicle vehicle=new Vehicle();
		vehicle.setName("abc");
		vehicle.setBrand("xyz");
		vehicle.setPrice(1000);
		vehicle.setColor("black");
		
		Registration registration =new Registration();
		registration.setRegistrationNo(102);
		registration.setCity("mumbai");
		
		//setting vehicle and registration
		registration.setVehicle(vehicle);
		vehicle.setRegistration(registration);
		
		entityTransaction.begin();
		entityManager.persist(vehicle);
		entityManager.persist(registration);
		entityTransaction.commit();
	}

}

