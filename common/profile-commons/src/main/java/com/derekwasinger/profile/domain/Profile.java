package com.derekwasinger.profile.domain;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "PROFILE")
public class Profile {

	public Profile() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "USERNAME", nullable = false, unique = true)
	private String userName;

	@Column(name = "FIRST_NAME", nullable = false, unique = false)
	private String firstName;

	@Column(name = "LAST_NAME", nullable = false, unique = false)
	private String lastName;

	@OneToMany(targetEntity = Address.class)
	private List<Address> addressList;

	@Column(name = "DOB", nullable = false, unique = false)
	private LocalDate dateOfBirth;

	@OneToOne
	private Generation generation;

}
