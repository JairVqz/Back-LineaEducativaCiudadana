package mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Models.Directorio;

public interface DirectorioRepository extends JpaRepository<Directorio, Long> {
    @Query(value = "SELECT * FROM vista_directorio ORDER BY nombreAreaInterna, nombreArea", nativeQuery = true)
    List<Object[]> findAllVistaD();

    @Query(value = "SELECT * FROM vista_directorio where idArea =:idArea ORDER BY nombreTramite ASC", nativeQuery = true)
    List<Object[]> findTramitesByArea(Long idArea);

    @Query(value = "SELECT idDirectorio, nombreArea, extension, nombreTramite, responsable FROM vista_directorio WHERE directorioActivo = 1 ORDER BY nombreAreaInterna, nombreArea", nativeQuery = true)
    List<Object[]> findAllExtensiones();

}
