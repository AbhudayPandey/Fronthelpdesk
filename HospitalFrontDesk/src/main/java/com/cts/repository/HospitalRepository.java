package com.cts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cts.model.Hospital;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Long> {

	@Query(value="SELECT * FROM hospital where hname=:hname",nativeQuery=true)
	Hospital  findBedsByHospitalName(@Param("hname")String hname);
}
