package mx.gob.sev.api.LineaEducativaCiudadana.Solicitud.Services.Ubicacion;

import java.util.List;

import mx.gob.sev.api.LineaEducativaCiudadana.Solicitud.Models.Ubicacion;

public interface UbicacionService {

    List<Ubicacion> findAll();
    Ubicacion save(Ubicacion ubicacion);
    
}
