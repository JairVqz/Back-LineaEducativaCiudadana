package mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Services.CatalogoAreaTramite;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Models.CatalogoAreaTramite;
import mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Repositories.CatalogoAreaTramiteRepository;

@Service
public class CatalogoAreaTramiteImpl implements CatalogoAreaTramiteService{

    @Autowired
    private CatalogoAreaTramiteRepository catalogoAreaTramiteRepository;

    @Override
    public List<CatalogoAreaTramite> findAll(){
        return (List<CatalogoAreaTramite>) this.catalogoAreaTramiteRepository.findAll();
    }

    @Override
    public CatalogoAreaTramite save(CatalogoAreaTramite catalogoAreaTramite){
        return this.catalogoAreaTramiteRepository.save(catalogoAreaTramite);
    }
    
}
