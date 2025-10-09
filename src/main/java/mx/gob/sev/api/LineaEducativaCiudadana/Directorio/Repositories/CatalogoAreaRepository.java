package mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Models.CatalogoArea;

public interface CatalogoAreaRepository extends JpaRepository<CatalogoArea, Long> {
    //activos
    @Query("SELECT c FROM CatalogoArea c WHERE c.activo = 1 ORDER BY c.nombre ASC")
    List<CatalogoArea> findAllActive();

    //inactivos
    @Query("SELECT c FROM CatalogoArea c WHERE c.activo = 0 ORDER BY c.nombre ASC")
    List<CatalogoArea> findAllInactive();

    //por id
    @Query("SELECT c FROM CatalogoArea c WHERE c.idArea = :idArea")
    Optional<CatalogoArea> findById(@Param("idArea") Long idArea);
}
