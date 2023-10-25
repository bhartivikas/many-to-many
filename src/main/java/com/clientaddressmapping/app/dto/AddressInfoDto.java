package com.clientaddressmapping.app.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressInfoDto {

	private Long addressId;

	private String street1;
	private String street2;
	private String city;
	private String state;
	private String zipcode;

}
