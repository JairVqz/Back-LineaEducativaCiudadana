package mx.gob.sev.api.LineaEducativaCiudadana.Solicitud.Repositories.Solicitud;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import mx.gob.sev.api.LineaEducativaCiudadana.Solicitud.Models.Solicitud.SolicitudGeneral;

public interface SolicitudGeneralRepository extends JpaRepository<SolicitudGeneral, Long> {

    // Buscar todos las solicitudes activas
    @Query("SELECT s FROM SolicitudGeneral s WHERE s.activo = 1 ORDER BY s.id DESC")
    List<SolicitudGeneral> findAllActive();

    @Query(value = "SELECT * FROM solicitud_general WHERE folio IS NOT NULL ORDER BY folio DESC LIMIT 1", nativeQuery = true)
    Optional<SolicitudGeneral> findFolioUltimaSolicitud();

}
