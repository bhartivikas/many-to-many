package com.clientaddressmapping.app.service.impl;

import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;

import com.clientaddressmapping.app.dto.ClientInfoDto;
import com.clientaddressmapping.app.dto.ClientSaveRequestDto;
import com.clientaddressmapping.app.entity.Address;
import com.clientaddressmapping.app.entity.Client;
import com.clientaddressmapping.app.repository.AddressRepository;
import com.clientaddressmapping.app.repository.ClientRepository;
import com.clientaddressmapping.app.service.ClientService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

	private final ClientRepository clientRepository;
	private final AddressRepository addressRepository;

	@Override
	public void saveClient(ClientSaveRequestDto clientSaveRequestDto) {

		// Create Address Entity Object
		Address address = null;

		// Checking whether the Request object should have address
		if (Objects.nonNull(clientSaveRequestDto.getAddressDto())) {

			// Now we have two conditions
			if (Objects.nonNull(clientSaveRequestDto.getAddressDto().getAddressId())) {

				var optionalAddress = this.addressRepository
						.findById(clientSaveRequestDto.getAddressDto().getAddressId());

				if (optionalAddress.isPresent()) {

					address = optionalAddress.get();

				}

			}

			// this condition will be executed when addressid is not present in database or
			// addressid is not provided by user
			if (Objects.isNull(address)) {
				address = new Address();
				address.setCity(clientSaveRequestDto.getAddressDto().getCity());
				address.setState(clientSaveRequestDto.getAddressDto().getState());
				address.setStreet1(clientSaveRequestDto.getAddressDto().getStreet1());
				address.setStreet2(clientSaveRequestDto.getAddressDto().getStreet2());
				address.setZipcode(clientSaveRequestDto.getAddressDto().getZipcode());
			}

		}

		Client clientEntity = new Client();
		clientEntity.setFirstName(clientSaveRequestDto.getFirstName());
		clientEntity.setLastName(clientSaveRequestDto.getLastName());
		clientEntity.setGender(clientSaveRequestDto.getGender());
		clientEntity.setEmail(clientSaveRequestDto.getEmail());

		if (Objects.nonNull(address)) {
			clientEntity.addAddress(address);
		}

		this.clientRepository.save(clientEntity);

	}

	@Override
	public ClientInfoDto getClientById(Long clientId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ClientInfoDto> getAllClients() {
		// TODO Auto-generated method stub
		return null;
	}

}
