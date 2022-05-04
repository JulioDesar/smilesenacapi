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

import br.com.smiledents.mosaic.model.Consulta;
import br.com.smiledents.mosaic.repository.Consulta_Repository;

@RestController
@RequestMapping(path = "/consulta")
public class Consulta_Controller {

    @Autowired
    private Consulta_Repository db;

    @GetMapping(path = "/")
    public List<Consulta> allConsultas() {
        return db.findAll();
    }

    @GetMapping(path = "/{id}")
    public Optional<Consulta> findConsultaById(@PathVariable int id) {
        return db.findById(id);
    }

    @PostMapping(path = "/")
    public Consulta saveConsulta(@RequestBody Consulta cons) {
        return db.save(cons);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<?> updateConsulta(@PathVariable int id, @RequestBody Consulta cons) {
        var resp = db.findById(id);

        if (resp.isPresent()) {
            var currentConsulta = resp.get();
            currentConsulta.setStatus(cons.getStatus());

            db.save(currentConsulta);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteConsulta(@PathVariable int id) {
        var resp = db.findById(id);

        if (resp.isPresent()) {
            db.deleteById(id);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }
}
