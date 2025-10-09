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

    // gestion solicitudes
    @Query(value = "SELECT * FROM vista_solicitud WHERE solicitudActiva=1 AND CAST(fecha AS DATE) BETWEEN :fecha_inicio AND :fecha_fin ORDER BY folio DESC", nativeQuery = true)
    List<Object[]> findAllActiveByRange(@Param("fecha_inicio") String fecha_inicio,
            @Param("fecha_fin") String fecha_fin);

    // REVISION SOLICITUDES
    // usuario es revisor
    @Query(value = """
                SELECT *
                FROM vista_solicitud
                WHERE solicitudActiva = 1
                  AND idTramite IN (:idsTramites)
                  AND CAST(fecha AS DATE) BETWEEN :fecha_inicio AND :fecha_fin
                ORDER BY folio DESC
            """, nativeQuery = true)
    List<Object[]> findAllActiveByRangeAndTramites(
            @Param("fecha_inicio") String fecha_inicio,
            @Param("fecha_fin") String fecha_fin,
            @Param("idsTramites") List<Integer> idsTramites);

    // usuario es supervisor de los revisores
    @Query(value = """
                SELECT *
                FROM vista_solicitud
                WHERE solicitudActiva = 1
                  AND idAreaSolicitud =:idArea
                  AND CAST(fecha AS DATE) BETWEEN :fecha_inicio AND :fecha_fin
                ORDER BY folio DESC
            """, nativeQuery = true)
    List<Object[]> findAllActiveByRangeAndArea(
            @Param("fecha_inicio") String fecha_inicio,
            @Param("fecha_fin") String fecha_fin,
            @Param("idArea") Long idArea);

    @Query(value = "SELECT * FROM tbl_solicitudesGeneral WHERE folio IS NOT NULL ORDER BY folio DESC LIMIT 1", nativeQuery = true)
    Optional<SolicitudGeneral> findFolioUltimaSolicitud();

    @Query(value = "SELECT * FROM vista_solicitud " +
            "WHERE nombre LIKE %:nombre% " +
            "AND apellidoPaterno LIKE %:apellidoPaterno% " +
            "AND apellidoMaterno LIKE %:apellidoMaterno% " +
            "AND CAST(fecha AS DATE) >= CAST(DATEADD(DAY, -60, GETDATE()) AS DATE) " +
            "ORDER BY folio", nativeQuery = true)
    List<Object[]> findCoincidenciasSolicitud(@Param("nombre") String nombre,
            @Param("apellidoPaterno") String apellidoPaterno,
            @Param("apellidoMaterno") String apellidoMaterno);

    @Query(value = "SELECT * FROM vista_solicitud " +
            "WHERE (" +
            "   (:atributoBusqueda = 'folio' AND folio LIKE %:valorBusqueda%) OR " +
            "   (:atributoBusqueda = 'correo' AND correo LIKE %:valorBusqueda%) OR " +
            "   (:atributoBusqueda = 'telefonoFijo' AND telefonoFijo LIKE %:valorBusqueda%) OR " +
            "   (:atributoBusqueda = 'telefonoCelular' AND telefonoCelular LIKE %:valorBusqueda%) OR " +
            "   (:atributoBusqueda = 'nombreCompleto' AND CONCAT(nombre, ' ', apellidoPaterno, ' ', apellidoMaterno) LIKE %:valorBusqueda%)"
            +
            ") " +
            "AND CAST(fecha AS DATE) >= CAST(DATEADD(DAY, -60, GETDATE()) AS DATE) " +
            "ORDER BY folio", nativeQuery = true)
    List<Object[]> findCoincidenciasInicio(
            @Param("atributoBusqueda") String atributoBusqueda,
            @Param("valorBusqueda") String valorBusqueda);

}