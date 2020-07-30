package com.cts.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.cache.annotation.CacheConfig;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@CacheConfig(cacheNames= {"specialist"})
public class Specialist {

	@Id
    private Long sid;
    private String type;
    private String sname;
    private String availableday;
    private String availabletime;
	@ManyToOne
	@JoinColumn(name= "hid")
	private Hospital hospital;
	@OneToMany
	private List<Patient> patient;
}    
