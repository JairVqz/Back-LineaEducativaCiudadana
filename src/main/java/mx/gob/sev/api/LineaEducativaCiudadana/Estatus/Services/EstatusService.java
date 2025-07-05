package mx.gob.sev.api.LineaEducativaCiudadana.Estatus.Services;

import java.util.List;

import mx.gob.sev.api.LineaEducativaCiudadana.Estatus.Models.Estatus;

public interface EstatusService {
    
    List<Estatus> findAll();
    
}
