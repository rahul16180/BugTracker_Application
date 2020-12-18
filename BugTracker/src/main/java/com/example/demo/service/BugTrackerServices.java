package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Bug;
import com.example.demo.repo.BugTrackerRepository;

@Service
public class BugTrackerServices {

	@Autowired
	private BugTrackerRepository repo;
	
	public Bug add(Bug entity) {
		
		return this.repo.save(entity);
	}
	
	
	public List<Bug> findAll(Integer pageNo, Integer pageSize){
		
		Pageable pageable = PageRequest.of(pageNo, pageSize);
		 
		Page<Bug> pageResult = repo.findAll(pageable); 
		
		if(pageResult.hasContent()){
			
			return pageResult.getContent();
		}
		else {
			
			return new ArrayList<Bug>();
		}
	}
	
	
	public Optional<Bug> findById(long id){
		
		return repo.findById(id);
	}
}
