package mx.gob.sev.api.LineaEducativaCiudadana.Solicitud.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import mx.gob.sev.api.LineaEducativaCiudadana.Solicitud.Models.SolicitudGeneral;

public interface SolicitudGeneralRepository extends JpaRepository<SolicitudGeneral, Long>{
    
    // Buscar todos los suministros activos
    @Query("SELECT s FROM SolicitudGeneral s WHERE s.activo = 1 ORDER BY s.id DESC")
    List<SolicitudGeneral> findAllActive();
}
