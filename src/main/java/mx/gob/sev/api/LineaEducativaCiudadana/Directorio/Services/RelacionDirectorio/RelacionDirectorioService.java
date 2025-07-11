package mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Services.RelacionDirectorio;

import java.util.List;

import mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Models.RelacionDirectorio;

public interface RelacionDirectorioService {

    List<RelacionDirectorio> findAll();
    RelacionDirectorio save(RelacionDirectorio relacionDirectorio);
    
}
