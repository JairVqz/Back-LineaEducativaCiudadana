package mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Services.Estructura;

import java.util.List;

import mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Models.EstructuraSev;

public interface EstructuraSevService {

    List<EstructuraSev> findAll();
    EstructuraSev save(EstructuraSev estructura);
    
}
