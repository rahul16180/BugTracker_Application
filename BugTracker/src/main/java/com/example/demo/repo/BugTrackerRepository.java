package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Bug;

public interface BugTrackerRepository extends JpaRepository<Bug, Long> {

	
}
