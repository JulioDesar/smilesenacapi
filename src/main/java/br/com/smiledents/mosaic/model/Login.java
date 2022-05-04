package br.com.smiledents.mosaic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "Login")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Login {

    @Id
    @Column(name = "Login_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "Usuario")
    private String Usuario;

    @Column(name = "Senha")
    private Integer Senha;

}