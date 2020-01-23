package com.derekwasinger.profile.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "GENERATION")
public class Generation {

	public Generation() {
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	@Column(name="NAME", length=50, nullable=false, unique=true)
	private String name;

	@Column(name="ALT_NAME", length=50, nullable=true, unique=false)
	private String alternativeName;

	@Column(name="START_YEAR", nullable=false, unique=false)
	private LocalDate startYear;

	@Column(name="ENDT_YEAR", nullable=false, unique=false)
	private LocalDate endYear;

}
