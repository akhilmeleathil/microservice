package com.learning.firstjobapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
public class Job {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int jobId;
	private String title;
	private String description;
	private int minSalary;
	private int maxSalary;
	private String location;
	
	@ManyToOne
	private Company company;
	
}
