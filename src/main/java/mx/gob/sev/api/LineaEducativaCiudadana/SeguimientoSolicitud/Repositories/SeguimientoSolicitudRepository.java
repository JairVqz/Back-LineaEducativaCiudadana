package mx.gob.sev.api.LineaEducativaCiudadana.SeguimientoSolicitud.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import mx.gob.sev.api.LineaEducativaCiudadana.SeguimientoSolicitud.Models.SeguimientoSolicitud;

public interface SeguimientoSolicitudRepository extends JpaRepository<SeguimientoSolicitud, Long> {
    // mensajes de un folio
    @Query("SELECT c FROM SeguimientoSolicitud c WHERE c.solicitud.idSolicitud =:idSolicitud ORDER BY c.fecha ASC")
    List<SeguimientoSolicitud> findAllByIdSolicitud(Long idSolicitud);
}
