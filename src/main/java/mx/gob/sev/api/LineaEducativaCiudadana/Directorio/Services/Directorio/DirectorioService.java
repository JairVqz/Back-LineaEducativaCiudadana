package mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Services.Directorio;

import java.util.List;

import mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Models.Directorio;

public interface DirectorioService {

    List<Directorio> findAll();
    Directorio save(Directorio relacionDirectorio);
    
}
