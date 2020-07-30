package com.cts.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cts.model.Patient;

@Repository
public interface PatientRepository extends JpaRepository <Patient, Long> {
	@Query(value= "SELECT s.sname,p.pname,s.type,s.availabletime,s.availableday FROM specialist s,patient p WHERE p.pname=:pname AND p.sid=s.sid", nativeQuery =true)
	 List<Object> findByName(@Param("pname") String pname);
	
@Query(value="SELECT p.pstatus from patient p where p.hid=:hid ",nativeQuery=true)
List<String> findAll(@Param("hid") int hid);
}
