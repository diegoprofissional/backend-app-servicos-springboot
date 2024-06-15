package br.com.syscomercial.appservico.services;

import br.com.syscomercial.appservico.data.DadosPrestadorServico;
import br.com.syscomercial.appservico.entities.PrestadorServico;
import br.com.syscomercial.appservico.repositories.PrestadorServicoRep;
import br.com.syscomercial.appservico.repositories.PrestadorServicoRep;
import br.com.syscomercial.appservico.utilitarios.ServicoS3;
import br.com.syscomercial.appservico.utilitarios.TratadorImagem;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class PrestadorServicoService {

    private final PrestadorServicoRep prestadorServicoRepository;


    public PrestadorServico save(PrestadorServico prestadorSErvico){
        return this.prestadorServicoRepository.save(prestadorSErvico);
    }

    public PrestadorServico updatePrestadorServico(DadosPrestadorServico dadosPrestadorServico){

        Optional<PrestadorServico> optionalPrestadorServico = this.prestadorServicoRepository.findById(dadosPrestadorServico.getId());

        PrestadorServico prestadorServico = optionalPrestadorServico.get();

        prestadorServico.setPrimeiroNome(dadosPrestadorServico.getPrimeiroNome());



        return this.prestadorServicoRepository.save(prestadorServico);
    }


    public PrestadorServico updateFotoPrestadorServico(Long id, MultipartFile arquivoFoto){

        Optional<PrestadorServico> optionalPrestadorServico = this.prestadorServicoRepository.findById(id);

        PrestadorServico prestadorServico = optionalPrestadorServico.get();

        TratadorImagem tratadorImagem = new TratadorImagem();

        String novaURLFoto = tratadorImagem.transformarArquivoFotoURL(arquivoFoto);


          prestadorServico.setFoto(novaURLFoto);

        return this.prestadorServicoRepository.save(prestadorServico);
    }



    public ResponseEntity getById(Long id){

        var prestadorServico = this.prestadorServicoRepository.findById(id);


        System.out.println("http");
        System.out.println(prestadorServico);
        return   ResponseEntity.ok(prestadorServico);
    }

    public Long getNumeroPrestadoresCadastrados(){

        Long numeroPrestadoresCadastrados = this.prestadorServicoRepository.count();


        return   numeroPrestadoresCadastrados;
    }

    public ResponseEntity deleteById(Long id){

        this.prestadorServicoRepository.deleteById(id);


        System.out.println("http");
        return   ResponseEntity.ok("");
    }

    public ResponseEntity search(Integer servicoProcurado){


        var classificacoes = this.prestadorServicoRepository.findByServicoNome(servicoProcurado);


        System.out.println("htddtp");
        System.out.println(classificacoes);
        return   ResponseEntity.ok(classificacoes);
    }

    public ResponseEntity getAll(){


        var todosPrestadoresServicos = this.prestadorServicoRepository.findAll();


        return   ResponseEntity.ok(todosPrestadoresServicos);
    }

    public String getFotoById(Long id){

        return this.prestadorServicoRepository.findFotoById(id);

    }

}