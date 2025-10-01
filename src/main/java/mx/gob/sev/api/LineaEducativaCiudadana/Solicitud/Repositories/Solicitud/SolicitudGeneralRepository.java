package mx.gob.sev.api.LineaEducativaCiudadana.Solicitud.Repositories.Solicitud;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import mx.gob.sev.api.LineaEducativaCiudadana.Solicitud.Models.Solicitud.SolicitudGeneral;

public interface SolicitudGeneralRepository extends JpaRepository<SolicitudGeneral, Long> {

        // Buscar todos las solicitudes activas
        @Query("SELECT s FROM SolicitudGeneral s WHERE s.activo = 1 ORDER BY s.id DESC")
        List<SolicitudGeneral> findAllActive();

        @Query(value = "SELECT * FROM tbl_solicitudesGeneral WHERE folio IS NOT NULL ORDER BY folio DESC LIMIT 1", nativeQuery = true)
        Optional<SolicitudGeneral> findFolioUltimaSolicitud();

        @Query(value = "SELECT * FROM vista_solicitud " +
                        "WHERE nombre LIKE %:nombre% " +
                        "AND apellidoPaterno LIKE %:apellidoPaterno% " +
                        "AND apellidoMaterno LIKE %:apellidoMaterno% " +
                        "ORDER BY folio", nativeQuery = true)
        List<Object[]> findCoincidenciasSolicitud(@Param("nombre") String nombre,
                        @Param("apellidoPaterno") String apellidoPaterno,
                        @Param("apellidoMaterno") String apellidoMaterno);

}