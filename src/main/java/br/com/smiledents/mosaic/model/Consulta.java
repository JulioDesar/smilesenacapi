package br.com.smiledents.mosaic.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

import org.springframework.format.annotation.DateTimeFormat;

import br.com.smiledents.mosaic.model.Enum.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "Consulta")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Consulta {

    @Id
    @Column(name = "Consulta_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    @Column(name = "Data_consulta")
    private LocalDateTime data_consulta;

    @Column(name = "Descricao")
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "Cliente_ID")
    private Cliente cliente_ID;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;
  
}
