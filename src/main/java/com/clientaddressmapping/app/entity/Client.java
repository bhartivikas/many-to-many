package com.clientaddressmapping.app.entity;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.clientaddressmapping.app.constants.Gender;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long clientId;

	private String firstName;
	private String lastName;

	@Enumerated(EnumType.STRING)
	private Gender gender;

	private String email;

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private Set<Address> addresses = new HashSet<>();

	public void addAddress(Address address) {
		this.addresses.add(address);
		address.getClients().add(this);
	}

	@Override
	public int hashCode() {
		return 2023;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		return Objects.equals(clientId, other.clientId);
	}
	
	

}
