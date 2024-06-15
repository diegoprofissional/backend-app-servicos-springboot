package br.com.syscomercial.appservico.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "administrador")
public class Administrador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String senha;

}
