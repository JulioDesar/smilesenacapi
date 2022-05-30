package br.com.smiledents.mosaic.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "cliente")
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

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(name = "data_aniversario")
    private LocalDate aniversario;

    @Column(name = "Endereco")
    private String endereco;

    @Column(name = "Telefone")
    private String telefone;
    
}
