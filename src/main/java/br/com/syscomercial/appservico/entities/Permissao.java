package br.com.syscomercial.appservico.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Permissao {

    @Id
    Long id;

    @Column
    String nome;

    @Column
    String permissao;

}
