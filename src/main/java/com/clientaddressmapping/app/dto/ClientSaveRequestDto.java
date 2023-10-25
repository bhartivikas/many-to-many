package com.clientaddressmapping.app.dto;

import com.clientaddressmapping.app.constants.Gender;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientSaveRequestDto {

	private String firstName;
	private String lastName;
	private Gender gender;
	private String email;
	private AddressDto addressDto;

}
