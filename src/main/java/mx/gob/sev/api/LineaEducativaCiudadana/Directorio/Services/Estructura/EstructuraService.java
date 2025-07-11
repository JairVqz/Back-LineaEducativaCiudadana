package mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Services.Estructura;

import java.util.List;

import mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Models.Estructura;

public interface EstructuraService {

    List<Estructura> findAll();
    Estructura save(Estructura estructura);
    
}
