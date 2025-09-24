package mx.gob.sev.api.LineaEducativaCiudadana.Usuario.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import mx.gob.sev.api.LineaEducativaCiudadana.Usuario.Models.RelacionAcceso;

public interface RelacionAccesoRepository extends JpaRepository<RelacionAcceso, Long> {
    // DIRECTORIO ASIGNADO A UN USUARIO
    @Query("SELECT c FROM RelacionAcceso c WHERE c.usuario.idUsuario = :idUsuario")
    List<RelacionAcceso> findDirectorioByUsuario(@Param("idUsuario") Long idUsuario);
}
