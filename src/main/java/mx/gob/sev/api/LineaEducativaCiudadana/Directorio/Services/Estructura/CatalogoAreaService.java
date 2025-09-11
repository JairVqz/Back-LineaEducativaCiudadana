package mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Services.Estructura;

import java.util.List;

import mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Models.CatalogoArea;

public interface CatalogoAreaService {

    List<CatalogoArea> findAll();
    List<CatalogoArea> findAllActive();
    List<CatalogoArea> findAllInactive();
    CatalogoArea findById(Long id);
    CatalogoArea save(CatalogoArea catalogoArea);
    CatalogoArea update (CatalogoArea catalogoArea);
    
}
