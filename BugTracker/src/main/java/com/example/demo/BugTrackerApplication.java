package com.example.demo;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.entity.Bug;
import com.example.demo.repo.BugTrackerRepository;

@SpringBootApplication
public class BugTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BugTrackerApplication.class, args);
	}

	
	@Bean
	public CommandLineRunner runner() {
		
		return new CommandLineRunner() {
			
			@Autowired
			private BugTrackerRepository repo;

			@Override
			public void run(String... args) throws Exception {
				// TODO Auto-generated method stub
				
				repo.save(new Bug(101101,"HIGH","WebApp-1.0","Can resolve the attribute type",LocalDate.of(2020,10,14)));
				
				repo.save(new Bug(8008080,"LOW","XMLDecoder-1.2","Cant find the tree root",LocalDate.of(2020,12,14)));				
				
			}
			
			
		};
	}
}
