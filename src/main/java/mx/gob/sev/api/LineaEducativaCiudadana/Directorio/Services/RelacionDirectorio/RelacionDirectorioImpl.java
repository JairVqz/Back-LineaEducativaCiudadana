package mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Services.RelacionDirectorio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Models.RelacionDirectorio;
import mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Repositories.RelacionDirectorioRepository;

@Service
public class RelacionDirectorioImpl implements RelacionDirectorioService {

    @Autowired
    private RelacionDirectorioRepository relacionDirectorioRepository;

    @Override
    public List<RelacionDirectorio> findAll(){
        return (List<RelacionDirectorio>) this.relacionDirectorioRepository.findAll();
    }

    @Override
    public RelacionDirectorio save(RelacionDirectorio relacionDirectorio){
        return this.relacionDirectorioRepository.save(relacionDirectorio);
    }
    
}
