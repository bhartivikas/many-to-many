package com.clientaddressmapping.app.dto;

import java.util.ArrayList;
import java.util.List;

import com.clientaddressmapping.app.constants.Gender;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientInfoDto {

	private Long clientId;

	private String firstName;
	private String lastName;

	private Gender gender;

	private String email;

	private List<AddressInfoDto> addresses = new ArrayList<>();

}
