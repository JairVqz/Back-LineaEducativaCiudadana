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

    // TRAMITES POR AREA
    @Query("SELECT c FROM CatalogoTramite c WHERE c.catalogoArea.idArea = :idArea")
    List<CatalogoTramite> findTramiteByArea(@Param("idArea") Long idArea);

    // tramites de un usuario al loguearse
    @Query("SELECT c FROM CatalogoTramite c WHERE c.activo = 1 AND c.idTramite IN (:idsTramites) ORDER BY c.tramite ASC")
    List<CatalogoTramite> findAllActiveTramitesByUsuario(@Param("idsTramites") List<Integer> idsTramites);
}
