package com.cts.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter 
@Setter

public class Hospital {
	@Id
    private Integer hid;
    private String hname;
    private Integer numberofbeds;
    @OneToMany
    private List<Specialist> specialist;
    @OneToMany
    private List<Patient> patient;

}
