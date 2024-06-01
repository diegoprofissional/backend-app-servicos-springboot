package br.com.syscomercial.appservico.data;


import lombok.Data;
import org.springframework.web.multipart.MultipartFile;


@Data
public class DadosPrestadorServico {

    private Long id;

    private String primeiroNome;

    private String sobrenome;

    private String cpf;

    private String cidade;

    private String foto;

    private String servicoEspecializado;

    private String descricao;

    private String celular;

    private Boolean segurancaResidencial;

    private Boolean eletrica;

    private Boolean internetRedes;

    private Boolean televisao;

    private Boolean telefonia;

    private Boolean limpezaDomestica;

    private Boolean instalacaoEquipamentos;

    private Boolean instalacaoCameras;

    private MultipartFile arquivoFoto;







}

