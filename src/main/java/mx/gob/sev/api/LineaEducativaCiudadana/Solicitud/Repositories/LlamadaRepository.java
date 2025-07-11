package mx.gob.sev.api.LineaEducativaCiudadana.Solicitud.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.gob.sev.api.LineaEducativaCiudadana.Solicitud.Models.Llamada;

public interface LlamadaRepository extends JpaRepository<Llamada, Long> {
    
}
