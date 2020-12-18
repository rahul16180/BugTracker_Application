package com.example.demo.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name="BugTrackerDB")
@Component
@Data
@FieldDefaults(level=AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class Bug {

	@Id
	long id;
	String priority;
	String project;
	String description;
	LocalDate date;
	
}
