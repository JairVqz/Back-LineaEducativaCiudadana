package mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Services.Estructura;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Models.EstructuraSev;
import mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Repositories.EstructuraSevRepository;

@Service
public class EstructuraSevImpl implements EstructuraSevService{

    @Autowired
    private EstructuraSevRepository estructuraSevRepository;

    @Override
    public List<EstructuraSev> findAll(){
        return (List<EstructuraSev>) this.estructuraSevRepository.findAll();
    }

    @Override
    public EstructuraSev save(EstructuraSev estructuraSev){
        return this.estructuraSevRepository.save(estructuraSev);
    }
    
}
