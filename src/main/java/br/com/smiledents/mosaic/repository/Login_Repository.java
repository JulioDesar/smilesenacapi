package br.com.smiledents.mosaic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.smiledents.mosaic.model.Login;

public interface Login_Repository extends JpaRepository<Login, Integer> {
    
}