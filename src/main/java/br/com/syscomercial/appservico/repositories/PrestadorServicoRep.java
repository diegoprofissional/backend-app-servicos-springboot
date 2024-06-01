package br.com.syscomercial.appservico.repositories;

import br.com.syscomercial.appservico.entities.PrestadorServico;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PrestadorServicoRep  extends CrudRepository<PrestadorServico, Long> {


    @Query("SELECT DISTINCT prestador_servico.* FROM prestador_servico INNER JOIN servico_prestado ON prestador_servico.id = servico_prestado.id_prestador_servico WHERE (:idServico IS NULL OR servico_prestado.id_tipo_servico_prestado = :idServico)")
    List<PrestadorServico> findByServicoNome(@Param("idServico") Integer idServico);

    List<PrestadorServico> findByServicoEspecializado(String servicoEspecializado);

    @Query("select foto from prestador_servico where id = :id")
    String findFotoById(@Param("id") Long id);


}