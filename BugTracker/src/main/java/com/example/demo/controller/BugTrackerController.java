package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Bug;
import com.example.demo.service.BugTrackerServices;

@RestController
@RequestMapping("/tracker/app")
@CrossOrigin(origins="*")
public class BugTrackerController {

	@Autowired
	BugTrackerServices services;
	
	@PostMapping(path = "/postbugs")
	@ResponseStatus(code=HttpStatus.CREATED)
	public Bug postAll(@RequestBody Bug bug) {
  
		return this.services.add(bug);
  
    }
	
	
	@GetMapping(path = "/bugs")
    public List<Bug> findAll(
                        @RequestParam(defaultValue = "0") Integer pageNo, 
                        @RequestParam(defaultValue = "5") Integer pageSize)
    {
        List<Bug> bugsList = services.findAll(pageNo, pageSize);
 
        return bugsList; 
    }
	
	
	@GetMapping(path = "/bugs/{id}")
	public Optional<Bug> findById(@PathVariable("id") long id) {
		
		return this.services.findById(id);
	}
	
}
