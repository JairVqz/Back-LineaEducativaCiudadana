package mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Services.Directorio;

import java.util.List;
import java.util.Map;

import mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Models.Directorio;
import mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Models.VistaDirectorio;

public interface DirectorioService {

    List<Directorio> findAll();

    Directorio save(Directorio relacionDirectorio);

    List<VistaDirectorio> findAllVistaD();

    List<VistaDirectorio> findTramitesByArea(Long idArea);

    List<Map<String, Object>> findAllExtensiones();

}
