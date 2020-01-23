package com.derekwasinger.profile.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "ADDRESS")
public class Address {

	public Address() {
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	@Column(name="HOUSE_BUMBER", nullable=false, unique=false)
	private Integer houseNumber;

	@Column(name="STREET", nullable=false, unique=false)
	private String street;

	@Column(name="CITY", nullable=false, unique=false)
	private String city;

	@Column(name="STATE", nullable=false, unique=false)
	private String state;

	@Column(name="ZIP_CODE", nullable=false, unique=false)
	private String zipCode;
	
}
