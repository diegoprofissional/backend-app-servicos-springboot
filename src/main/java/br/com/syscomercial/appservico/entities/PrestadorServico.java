package br.com.syscomercial.appservico.entities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import jakarta.persistence.*;


@Data
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Table(name = "prestador_servico")
public class PrestadorServico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "primeiro_nome")
    private String primeiroNome;

    @Column(name = "sobrenome")
    private String sobrenome;

    private String cpf;

    private String cidade;

    private String foto;

    private String descricao;

    private String servicoEspecializado;

    private String celular;

}

