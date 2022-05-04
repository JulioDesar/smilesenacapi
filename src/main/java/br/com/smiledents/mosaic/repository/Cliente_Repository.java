package br.com.smiledents.mosaic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.smiledents.mosaic.model.Cliente;

public interface Cliente_Repository extends JpaRepository<Cliente, Integer> {
    
}
