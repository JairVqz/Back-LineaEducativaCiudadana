package mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Services.CatalogoTramite;

import java.util.List;

import mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Models.CatalogoTramite;

public interface CatalogoTramiteService {
    
    List<CatalogoTramite> findAll();
    CatalogoTramite save(CatalogoTramite catalogoTramite);
}
