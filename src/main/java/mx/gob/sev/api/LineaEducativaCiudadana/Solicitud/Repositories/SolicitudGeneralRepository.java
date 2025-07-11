package mx.gob.sev.api.LineaEducativaCiudadana.Solicitud.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.gob.sev.api.LineaEducativaCiudadana.Solicitud.Models.SolicitudGeneral;

public interface SolicitudGeneralRepository extends JpaRepository<SolicitudGeneral, Long>{
    
}
