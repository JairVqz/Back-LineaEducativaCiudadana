package mx.gob.sev.api.LineaEducativaCiudadana.Usuario.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.gob.sev.api.LineaEducativaCiudadana.Usuario.Models.RelacionAcceso;

public interface RelacionAccesoRepository extends JpaRepository<RelacionAcceso, Long>{
    
}
