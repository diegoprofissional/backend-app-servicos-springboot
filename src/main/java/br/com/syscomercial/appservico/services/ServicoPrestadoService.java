package br.com.syscomercial.appservico.services;

import br.com.syscomercial.appservico.entities.PrestadorServico;
import br.com.syscomercial.appservico.entities.ServicoPrestado;
import br.com.syscomercial.appservico.repositories.PrestadorServicoRep;
import br.com.syscomercial.appservico.repositories.ServicoPrestadoRep;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ServicoPrestadoService {

    private final ServicoPrestadoRep servicoPrestadoRep;


    public ServicoPrestado save(ServicoPrestado servicoPrestado){
        return this.servicoPrestadoRep.save(servicoPrestado);
    }


//    public ResponseEntity getById(Long id){
//
//        var prestadorServico = this.prestadorServicoRepository.findById(id);
//
//
//        System.out.println("http");
//        System.out.println(prestadorServico);
//        return   ResponseEntity.ok(prestadorServico);
//    }
//
//    public ResponseEntity search(String servicoProcurado){
//
//
//        var classificacoes = this.prestadorServicoRepository.findByServicoEspecializado(servicoProcurado);
//
//
//        System.out.println("http");
//        System.out.println(classificacoes);
//        return   ResponseEntity.ok(classificacoes);
//    }

}