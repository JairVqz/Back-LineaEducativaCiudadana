package mx.gob.sev.api.LineaEducativaCiudadana.Estatus.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.gob.sev.api.LineaEducativaCiudadana.Estatus.Models.Estatus;

public interface EstatusRepository extends JpaRepository<Estatus, Long> {
    
}