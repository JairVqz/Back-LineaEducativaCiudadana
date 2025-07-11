package mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Services.Estructura;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Models.Estructura;
import mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Repositories.EstructuraRepository;

@Service
public class EstructuraImpl implements EstructuraService{

    @Autowired
    private EstructuraRepository estructuraRepository;

    @Override
    public List<Estructura> findAll(){
        return (List<Estructura>) this.estructuraRepository.findAll();
    }

    @Override
    public Estructura save(Estructura estructura){
        return this.estructuraRepository.save(estructura);
    }
    
}
