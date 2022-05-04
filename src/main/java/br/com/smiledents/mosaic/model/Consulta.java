package br.com.smiledents.mosaic.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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

    @Column(name = "Data_consulta")
    private Date data_consulta;

    @Column(name = "Descricao")
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "Cliente_ID")
    private Cliente cliente_ID;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;
  
}
