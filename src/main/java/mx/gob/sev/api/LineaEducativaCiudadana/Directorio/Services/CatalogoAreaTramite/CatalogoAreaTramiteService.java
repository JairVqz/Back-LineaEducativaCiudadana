package mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Services.CatalogoAreaTramite;

import java.util.List;

import mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Models.CatalogoAreaTramite;

public interface CatalogoAreaTramiteService {
    
    List<CatalogoAreaTramite> findAll();
    CatalogoAreaTramite save(CatalogoAreaTramite catalogoAreaTramite);
}
