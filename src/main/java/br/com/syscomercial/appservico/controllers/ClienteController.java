package br.com.syscomercial.appservico.controllers;

import br.com.syscomercial.appservico.services.PrestadorServicoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/clientes")
public class ClienteController {


    private final PrestadorServicoService prestadorServicoService;





    @GetMapping("{id}")
    ResponseEntity getById(@PathVariable Long id){

        var prestadorServico = this.prestadorServicoService.getById(id);

        return  ResponseEntity.ok(prestadorServico);
    }



}
