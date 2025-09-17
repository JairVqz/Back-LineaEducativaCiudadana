package mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Services.CatalogoTramite;

import java.util.List;

import mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Models.CatalogoTramite;

public interface CatalogoTramiteService {
    
    List<CatalogoTramite> findAll();
    List<CatalogoTramite> findAllActive();
    List<CatalogoTramite> findAllInactive();
    CatalogoTramite findById(Long idTramite);
    CatalogoTramite save(CatalogoTramite catalogoTramite);
    CatalogoTramite update (CatalogoTramite catalogoTramite);
}
