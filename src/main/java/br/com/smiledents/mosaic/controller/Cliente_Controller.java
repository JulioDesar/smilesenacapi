package br.com.smiledents.mosaic.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.smiledents.mosaic.model.Cliente;
import br.com.smiledents.mosaic.repository.Cliente_Repository;

@RestController
@RequestMapping(path = "/cliente")
public class Cliente_Controller {

    @Autowired
    private Cliente_Repository db;

    @GetMapping(path = "/")
    public List<Cliente> allClientes() {
        return db.findAll();
    }

    @GetMapping(path = "/{id}")
    public Optional<Cliente> findClienteById(@PathVariable int id) {
        return db.findById(id);
    }

    @PostMapping(path = "/")
    public Cliente saveCliente(@RequestBody Cliente cli) {
        return db.save(cli);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<?> updateCliente(@PathVariable int id, @RequestBody Cliente cli) {
        var resp = db.findById(id);

        if (resp.isPresent()) {
            var currentCliente = resp.get();
            currentCliente.setNome(cli.getNome());
            currentCliente.setEmail(cli.getEmail());
            currentCliente.setEndereco(cli.getEndereco());
            currentCliente.setTelefone(cli.getTelefone());
            db.save(currentCliente);

            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteCliente(@PathVariable int id) {
        var resp = db.findById(id);

        if (resp.isPresent()) {
            db.deleteById(id);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }
}
