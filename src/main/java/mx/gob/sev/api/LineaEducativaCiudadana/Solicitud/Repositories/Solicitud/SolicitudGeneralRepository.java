package mx.gob.sev.api.LineaEducativaCiudadana.Solicitud.Repositories.Solicitud;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import mx.gob.sev.api.LineaEducativaCiudadana.Solicitud.Models.Solicitud.SolicitudGeneral;

public interface SolicitudGeneralRepository extends JpaRepository<SolicitudGeneral, Long> {

        // Buscar todos las solicitudes activas
        @Query(value = "SELECT * FROM vista_solicitud WHERE solicitudActiva = 1 ORDER BY idSolicitud", nativeQuery = true)
        List<Object[]> findAllActive();

        //select * from vista_solicitud where solicitudActiva=1 and CAST(fecha AS DATE) BETWEEN '2025-09-01' AND '2025-10-02'; por rangos de fecha
        @Query(value = "SELECT * FROM vista_solicitud WHERE solicitudActiva=1 AND CAST(fecha AS DATE) BETWEEN :fecha_inicio AND :fecha_fin ORDER BY idSolicitud", nativeQuery = true)
        List<Object[]> findAllActiveByRange(@Param("fecha_inicio") String fecha_inicio, @Param("fecha_fin") String fecha_fin);

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