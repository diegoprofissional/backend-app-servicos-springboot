package br.com.syscomercial.appservico.repositories;

import br.com.syscomercial.appservico.entities.PrestadorServico;
import br.com.syscomercial.appservico.entities.ServicoPrestado;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ServicoPrestadoRep extends CrudRepository<ServicoPrestado, Long> {



}