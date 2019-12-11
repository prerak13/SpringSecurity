package com.example.demo.modelAndRepo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="vehicles")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class VehicleModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id ;
	@Getter
	@Setter
	@Column
	private String name;	
	 
	public void setName(String n) {
		this.name=n;
	}
	public String getName() {
		return this.name;
	}
	
}
