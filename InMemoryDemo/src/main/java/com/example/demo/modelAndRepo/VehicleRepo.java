package com.example.demo.modelAndRepo;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
	@Qualifier("p")
	public interface VehicleRepo extends JpaRepository<VehicleModel, Long> {
	}