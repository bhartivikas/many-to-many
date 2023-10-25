package com.clientaddressmapping.app.service;

import java.util.List;

import com.clientaddressmapping.app.dto.ClientInfoDto;
import com.clientaddressmapping.app.dto.ClientSaveRequestDto;

public interface ClientService {
	
	 void saveClient(ClientSaveRequestDto clientSaveRequestDto);
	 
	 ClientInfoDto getClientById(Long clientId);
	 
	List<ClientInfoDto> getAllClients();
	 

}
