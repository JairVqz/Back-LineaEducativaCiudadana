package mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Models.EstructuraSev;

public interface EstructuraSevRepository extends JpaRepository<EstructuraSev, Long> {
    
}
