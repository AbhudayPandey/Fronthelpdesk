package com.cts.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cts.model.Specialist;

@Repository
public  interface  SpecialistRepository extends JpaRepository<Specialist, Long> {
	@Query(value= "SELECT * FROM specialist s,hospital h WHERE h.hname =:hname and s.type=:type AND h.hid= s.hid", nativeQuery =true)
	 List<Specialist> findSpecDetails(@Param("hname") String hname, @Param("type") String type);
	
	
	@Query(value= "SELECT * FROM specialist s Where s.type=:type AND s.availabletime=:availabletime AND s.availableday=:availableday", nativeQuery =true)
	 List<Specialist> getDetails(@Param("type") String type, @Param("availabletime") String availabletime, @Param("availableday") String availableday);
}
