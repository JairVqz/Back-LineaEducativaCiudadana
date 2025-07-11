package mx.gob.sev.api.LineaEducativaCiudadana.Solicitud.Services.Llamada;

import java.util.List;

import mx.gob.sev.api.LineaEducativaCiudadana.Solicitud.Models.Llamada;

public interface LlamadaService {

    List<Llamada> findAll();
    Llamada save(Llamada llamada);
    
}
