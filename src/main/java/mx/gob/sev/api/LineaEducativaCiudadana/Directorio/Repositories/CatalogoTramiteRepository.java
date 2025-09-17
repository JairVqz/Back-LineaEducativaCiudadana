package mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Models.CatalogoTramite;

public interface CatalogoTramiteRepository extends JpaRepository<CatalogoTramite, Long> {
    // activos
    @Query("SELECT c FROM CatalogoTramite c WHERE c.activo = 1 ORDER BY c.idTramite")
    List<CatalogoTramite> findAllActive();

    // inactivos
    @Query("SELECT c FROM CatalogoTramite c WHERE c.activo = 0 ORDER BY c.idTramite")
    List<CatalogoTramite> findAllInactive();

    // por id
    @Query("SELECT c FROM CatalogoTramite c WHERE c.idTramite = :idTramite")
    Optional<CatalogoTramite> findById(@Param("idTramite") Long idTramite);
}
