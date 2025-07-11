package mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Models.Directorio;

public interface DirectorioRepository extends JpaRepository<Directorio, Long>{
    
}
