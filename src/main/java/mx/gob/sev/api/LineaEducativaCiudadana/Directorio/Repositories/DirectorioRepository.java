package mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Models.Directorio;

public interface DirectorioRepository extends JpaRepository<Directorio, Long> {
    @Query(value = "SELECT * FROM vista_directorio WHERE directorioActivo = 1 ORDER BY nombreAreaInterna, nombreArea", nativeQuery = true)
    List<Object[]> findAllVistaDActivo();

    @Query(value = "SELECT * FROM vista_directorio WHERE directorioActivo = 0 ORDER BY nombreAreaInterna, nombreArea", nativeQuery = true)
    List<Object[]> findAllVistaDInactivo();

    @Query(value = "SELECT * FROM vista_directorio where idArea =:idArea AND directorioActivo = 1 ORDER BY nombreTramite ASC", nativeQuery = true)
    List<Object[]> findTramitesByAreaActivo(Long idArea);

    @Query(value = "SELECT * FROM vista_directorio where idArea =:idArea AND directorioActivo = 0 ORDER BY nombreTramite ASC", nativeQuery = true)
    List<Object[]> findTramitesByAreaInactivo(Long idArea);

    @Query(value = "SELECT idDirectorio, nombreArea, extension, nombreTramite, responsable FROM vista_directorio WHERE directorioActivo = 1 ORDER BY nombreAreaInterna, nombreArea", nativeQuery = true)
    List<Object[]> findAllExtensiones();

    @Modifying
    @Query("UPDATE Directorio d SET d.activo=1 WHERE d.idDirectorio = :idDirectorio")
    void reactivateByIdDirectorio(@Param("idDirectorio") Long id);

    @Modifying
    @Query("UPDATE Directorio d SET d.activo=0 WHERE d.idDirectorio = :idDirectorio")
    void desactivateByIdDirectorio(@Param("idDirectorio") Long id);

    

}
