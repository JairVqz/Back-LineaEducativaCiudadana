package mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Services.CatalogoExtension;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Models.CatalogoExtension;
import mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Repositories.CatalogoExtensionRepository;

@Service
public class CatalogoExtensionImpl implements CatalogoExtensionService{

    @Autowired
    private CatalogoExtensionRepository catalogoExtensionRepository;

    @Override
    public List<CatalogoExtension> findAll(){
        return (List<CatalogoExtension>) this.catalogoExtensionRepository.findAll();
    }

    @Override
    public CatalogoExtension save(CatalogoExtension bitacora){
        return this.catalogoExtensionRepository.save(bitacora);
    }
    
}
