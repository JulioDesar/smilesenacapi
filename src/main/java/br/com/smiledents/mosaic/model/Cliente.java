package br.com.smiledents.mosaic.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "Cliente")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

    @Id
    @Column(name = "Cliente_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "CPF")
    private Long cpf;

    @Column(name = "Nome")
    private String nome;

    @Column(name = "email")
    private String email;

    @Column(name = "data_aniversario")
    private Date aniversario;

    @Column(name = "Endereço")
    private String endereco;

    @Column(name = "Telefone")
    private String telefone;
    
}
