package com.clientaddressmapping.app.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clientaddressmapping.app.dto.ClientSaveRequestDto;
import com.clientaddressmapping.app.service.ClientService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/client")
public class ClientController {

	private final ClientService clientService;

	@PostMapping
	public void saveClient(@RequestBody ClientSaveRequestDto clientSaveRequestDto) {
		this.clientService.saveClient(clientSaveRequestDto);
	}

}
