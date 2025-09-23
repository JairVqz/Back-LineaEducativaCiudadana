package mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Models.Directorio;

public interface DirectorioRepository extends JpaRepository<Directorio, Long> {
    @Query(value = "SELECT * FROM vista_directorio ORDER BY nombreAreaInterna, nombreArea", nativeQuery = true)
    List<Object[]> findAllVistaD();
}
