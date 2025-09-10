package mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Services.CatalogoTramite;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Models.CatalogoTramite;
import mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Repositories.CatalogoTramiteRepository;

@Service
public class CatalogoTramiteImpl implements CatalogoTramiteService{

    @Autowired
    private CatalogoTramiteRepository catalogoTramiteRepository;

    @Override
    public List<CatalogoTramite> findAll(){
        return (List<CatalogoTramite>) this.catalogoTramiteRepository.findAll();
    }

    @Override
    public CatalogoTramite save(CatalogoTramite catalogoTramite){
        return this.catalogoTramiteRepository.save(catalogoTramite);
    }
    
}
