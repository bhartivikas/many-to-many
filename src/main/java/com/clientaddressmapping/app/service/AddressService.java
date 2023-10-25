package com.clientaddressmapping.app.service;

import com.clientaddressmapping.app.dto.AddressSearchResponseDto;

public interface AddressService {
	
	AddressSearchResponseDto findByAddressId(Long addressId);

}
