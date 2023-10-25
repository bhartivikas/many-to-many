package com.clientaddressmapping.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clientaddressmapping.app.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
