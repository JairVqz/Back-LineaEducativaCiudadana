package mx.gob.sev.api.LineaEducativaCiudadana.Bitacora.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.gob.sev.api.LineaEducativaCiudadana.Bitacora.Models.Bitacora;

public interface BitacoraRepository extends JpaRepository<Bitacora, Long>{
    
}
