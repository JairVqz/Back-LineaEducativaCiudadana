package mx.gob.sev.api.LineaEducativaCiudadana.Estatus.Repositories;

import org.springframework.data.repository.CrudRepository;

import mx.gob.sev.api.LineaEducativaCiudadana.Estatus.Models.Estatus;

public interface EstatusRepository extends CrudRepository<Estatus, Long> {
    
}