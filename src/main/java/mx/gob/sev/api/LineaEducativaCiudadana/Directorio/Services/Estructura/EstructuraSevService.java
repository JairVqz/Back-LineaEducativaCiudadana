package mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Services.Estructura;

import java.util.List;

import mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Models.EstructuraSev;

public interface EstructuraSevService {

    List<EstructuraSev> findAll();
    List<EstructuraSev> findAllActive();
    List<EstructuraSev> findAllInactive();
    EstructuraSev findById(Long id);
    EstructuraSev save(EstructuraSev estructura);
    EstructuraSev update (EstructuraSev estructura);
    
}
