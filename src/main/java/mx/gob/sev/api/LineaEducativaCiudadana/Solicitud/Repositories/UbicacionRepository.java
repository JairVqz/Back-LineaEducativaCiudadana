package mx.gob.sev.api.LineaEducativaCiudadana.Solicitud.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.gob.sev.api.LineaEducativaCiudadana.Solicitud.Models.Ubicacion;

public interface UbicacionRepository extends JpaRepository<Ubicacion, Long>{
    
}
