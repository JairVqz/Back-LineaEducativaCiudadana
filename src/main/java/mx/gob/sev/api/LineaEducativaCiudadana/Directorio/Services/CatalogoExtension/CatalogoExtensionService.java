package mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Services.CatalogoExtension;

import java.util.List;

import mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Models.CatalogoExtension;

public interface CatalogoExtensionService {
 
    List<CatalogoExtension> findAll();
    CatalogoExtension save(CatalogoExtension catalogoExtension);
    
}