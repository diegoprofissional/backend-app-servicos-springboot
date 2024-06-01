package br.com.syscomercial.appservico.controllers;

import br.com.syscomercial.appservico.data.DadosPrestadorServico;
import br.com.syscomercial.appservico.entities.PrestadorServico;
import br.com.syscomercial.appservico.entities.ServicoPrestado;
import br.com.syscomercial.appservico.services.PrestadorServicoService;
import br.com.syscomercial.appservico.services.ServicoPrestadoService;
import br.com.syscomercial.appservico.utilitarios.TratadorImagem;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/prestadores-servicos")
public class PrestadorServicoController {


    private final PrestadorServicoService prestadorServicoService;
    private final ServicoPrestadoService servicoPrestadoService;



    @CrossOrigin(origins = "*")
    @GetMapping()
    ResponseEntity getPrestadoresServico(@RequestParam( value = "servicoProcurado", required = false) Integer servicoProcurado){

        var prestadoresServicos = this.prestadorServicoService.search(servicoProcurado);

        return  ResponseEntity.ok(prestadoresServicos.getBody());
    }

    //@CrossOrigin(origins = "*")
   // @GetMapping
   // ResponseEntity getAll(){

      //  var prestadoresServicos = this.prestadorServicoService.getAll();

      //  return  ResponseEntity.ok(prestadoresServicos.getBody());
    //}

    @CrossOrigin(origins = "*")
    @GetMapping("{id}")
    ResponseEntity getById(@PathVariable Long id){

        var prestadorServico = this.prestadorServicoService.getById(id);

        return  ResponseEntity.ok(prestadorServico.getBody());
    }



    @CrossOrigin(origins = "*")
    @GetMapping("/fotos/{id}")
    ResponseEntity getFotoById(@PathVariable Long id){

        String urlFotoAWSS3 = this.prestadorServicoService.getFotoById(id);

        return  ResponseEntity.ok(urlFotoAWSS3);
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("{id}")
    ResponseEntity deleteById(@PathVariable Long id){

        var prestadorServico = this.prestadorServicoService.deleteById(id);

        return  ResponseEntity.ok("");
    }

    @CrossOrigin(origins = "*")
    @PostMapping()
    ResponseEntity post(@ModelAttribute DadosPrestadorServico prestadorServico,
                        @RequestParam("arquivoFoto") MultipartFile arquivoFoto){


        TratadorImagem tratadorImagem = new TratadorImagem();

       String urlFotoAWSS3 = tratadorImagem.transformarArquivoFotoURL(arquivoFoto);

       PrestadorServico ps = new PrestadorServico();
       ps.setCidade(prestadorServico.getCidade());
       ps.setPrimeiroNome(prestadorServico.getPrimeiroNome());
       ps.setSobrenome(prestadorServico.getSobrenome());
       ps.setFoto(urlFotoAWSS3);
       ps.setCpf(prestadorServico.getCpf());
       ps.setServicoEspecializado((prestadorServico.getServicoEspecializado()));
       ps.setDescricao(prestadorServico.getDescricao());
       ps.setCelular(prestadorServico.getCelular());
       ps.setDescricao(prestadorServico.getDescricao());

        br.com.syscomercial.appservico.entities.PrestadorServico savedPs = prestadorServicoService.save(ps);

        if(prestadorServico.getSegurancaResidencial()){
            br.com.syscomercial.appservico.entities.ServicoPrestado sp = new ServicoPrestado();
           sp.setIdPrestadorServico(savedPs.getId());
           sp.setIdTipoServicoPrestado(5);
            this.servicoPrestadoService.save(sp);
        }


        if(prestadorServico.getEletrica()){
            br.com.syscomercial.appservico.entities.ServicoPrestado sp = new ServicoPrestado();
            sp.setIdPrestadorServico(savedPs.getId());
            sp.setIdTipoServicoPrestado(6);
            this.servicoPrestadoService.save(sp);
        }


        if(prestadorServico.getInternetRedes()){
            br.com.syscomercial.appservico.entities.ServicoPrestado sp = new ServicoPrestado();
            sp.setIdPrestadorServico(savedPs.getId());
            sp.setIdTipoServicoPrestado(7);
            this.servicoPrestadoService.save(sp);
        }

        if(prestadorServico.getTelevisao()){
            br.com.syscomercial.appservico.entities.ServicoPrestado sp = new ServicoPrestado();
            sp.setIdPrestadorServico(savedPs.getId());
            sp.setIdTipoServicoPrestado(8);
            this.servicoPrestadoService.save(sp);
        }

        if(prestadorServico.getTelefonia()){
            br.com.syscomercial.appservico.entities.ServicoPrestado sp = new ServicoPrestado();
            sp.setIdPrestadorServico(savedPs.getId());
            sp.setIdTipoServicoPrestado(9);
            this.servicoPrestadoService.save(sp);
        }

        if(prestadorServico.getLimpezaDomestica()){
            br.com.syscomercial.appservico.entities.ServicoPrestado sp = new ServicoPrestado();
            sp.setIdPrestadorServico(savedPs.getId());
            sp.setIdTipoServicoPrestado(10);
            this.servicoPrestadoService.save(sp);
        }

        if(prestadorServico.getInstalacaoEquipamentos()){
            br.com.syscomercial.appservico.entities.ServicoPrestado sp = new ServicoPrestado();
            sp.setIdPrestadorServico(savedPs.getId());
            sp.setIdTipoServicoPrestado(11);
            this.servicoPrestadoService.save(sp);
        }


        if(prestadorServico.getInstalacaoCameras()){
            br.com.syscomercial.appservico.entities.ServicoPrestado sp = new ServicoPrestado();
            sp.setIdPrestadorServico(savedPs.getId());
            sp.setIdTipoServicoPrestado(12);
            this.servicoPrestadoService.save(sp);
        }

        return  ResponseEntity.created( URI.create("https://localhost:8080/prestador-servico/")).build();
    }

    @CrossOrigin(origins = "*")
    @PutMapping("{id}")
    ResponseEntity put(@ModelAttribute DadosPrestadorServico dadosPrestadorServico){

        prestadorServicoService.updatePrestadorServico(dadosPrestadorServico);

        return  ResponseEntity.created( URI.create("https://localhost:8080/prestador-servico/")).build();
    }

    @CrossOrigin(origins = "*")
    @PutMapping("fotos/{id}")
    ResponseEntity putFoto(@PathVariable Long id,
                           @RequestParam("arquivoFoto") MultipartFile arquivoFoto){

        prestadorServicoService.updateFotoPrestadorServico(id, arquivoFoto);

        return  ResponseEntity.created( URI.create("https://localhost:8080/prestador-servico/")).build();
    }

    @CrossOrigin(origins = "*")
    @GetMapping("analitico/numero-cadastros")
    ResponseEntity getNumeroPrestadoresCadastrados(){

        Long numeroCadastros = this.prestadorServicoService.getNumeroPrestadoresCadastrados();

        return  ResponseEntity.ok(numeroCadastros);
    }

}
