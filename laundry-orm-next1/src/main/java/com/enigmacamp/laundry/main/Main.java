package com.enigmacamp.laundry.main;

import java.sql.SQLException;
import java.util.List;

import com.enigmacamp.laundry.db.entities.Customers;
import com.enimgacamp.laundry.db.repository.AdminRepository;
import com.enimgacamp.laundry.db.repository.CustomersRepository;
import com.enimgacamp.laundry.db.repository.LaundryItemsRepository;
import com.enimgacamp.laundry.db.repository.LaundryServiceRepository;
import com.enimgacamp.laundry.db.repository.TransaksiRepository;

public class Main {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		hibernateSample();
	}
	
	
	private static void hibernateSample() throws SQLException {
		System.out.println("PROJECT: laundry-orm-hibernate");
		AdminRepository adminRepo = new AdminRepository();
		CustomersRepository customRepo = new CustomersRepository();
		LaundryItemsRepository itemRepo = new LaundryItemsRepository();
		LaundryServiceRepository serviceRepo = new LaundryServiceRepository();
		TransaksiRepository transRepo = new TransaksiRepository();
		
		System.out.println("==================LIST COSTUMERS===========================");
		List<Customers> custom = customRepo.findAll();
		for (Customers ab : custom) {
			System.out.println(ab);
		}
		
		
		System.out.println("=====================ADD CUSTOMERS==============================");
	
		Customers surya =  new Customers();
		surya.setName("Rizal Abdi");
		surya.setAlamat("Jl.Tiger No. 8");
		surya.setTelepon(9238172);
		
//		surya = customRepo.addCustom(surya);
		
		System.out.println("==========================UPDATE CUSTOMERS==========================");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
