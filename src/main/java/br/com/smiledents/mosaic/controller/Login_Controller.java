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

import br.com.smiledents.mosaic.model.Login;
import br.com.smiledents.mosaic.repository.Login_Repository;

@RestController
@RequestMapping(path = "/login")
public class Login_Controller {

    @Autowired
    private Login_Repository db;

    @GetMapping(path = "/")
    public List<Login> allLogin() {
        return db.findAll();
    }

    @GetMapping(path = "/{id}")
    public Optional<Login> findLoginById(@PathVariable int id) {
        return db.findById(id);
    }

    @PostMapping(path = "/")
    public Login saveLogin(@RequestBody Login login) {
        return db.save(login);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<?> updateLogin(@PathVariable int id, @RequestBody Login login) {
        var usua = db.findById(id);

        if (usua.isPresent()) {
            var currentLogin = usua.get();
            currentLogin.setUsuario(login.getUsuario());
            currentLogin.setSenha(login.getSenha());
            db.save(currentLogin);

            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteLogin(@PathVariable int id) {
        var usu = db.findById(id);

        if (usu.isPresent()) {
            db.deleteById(id);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }
}