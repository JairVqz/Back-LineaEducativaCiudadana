package mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Models.EstructuraSev;

public interface EstructuraSevRepository extends JpaRepository<EstructuraSev, Long> {
    //activos
    @Query("SELECT c FROM EstructuraSev c WHERE c.activo = 1 ORDER BY c.idEstructura")
    List<EstructuraSev> findAllActive();

    //inactivos
    @Query("SELECT c FROM EstructuraSev c WHERE c.activo = 0 ORDER BY c.idEstructura")
    List<EstructuraSev> findAllInactive();

    //por id
    @Query("SELECT c FROM EstructuraSev c WHERE c.idEstructura = :idEstructura")
    Optional<EstructuraSev> findById(@Param("idEstructura") Long idEstructura);
}
