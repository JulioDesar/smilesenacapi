package br.com.smiledents.mosaic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.smiledents.mosaic.model.Cliente;

public interface Cliente_Repository extends JpaRepository<Cliente, Integer> {

    List<Cliente> findByNome(String nome);

    @Query("select c from cliente c where nome like %?1%")
    List<Cliente> findByParcialNome(String nome);

    @Query("select c from cliente c where CPF like %?1%")
    List<Cliente> findByParcialCpf(Long cpf);
    
}
