package mx.gob.sev.api.LineaEducativaCiudadana.Solicitud.Repositories.FolioSecuencia;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.persistence.LockModeType;
import mx.gob.sev.api.LineaEducativaCiudadana.Solicitud.Models.FolioSecuencia.FolioSecuencia;

public interface FolioSecuenciaRepository extends JpaRepository<FolioSecuencia, Long> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("SELECT f FROM FolioSecuencia f WHERE f.anioMes = :anioMes")
    Optional<FolioSecuencia> findByAnioMesForUpdate(@Param("anioMes") String anioMes);
    
}

