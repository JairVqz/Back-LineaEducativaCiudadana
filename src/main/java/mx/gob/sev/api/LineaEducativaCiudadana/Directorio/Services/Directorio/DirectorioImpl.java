package mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Services.Directorio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Models.Directorio;
import mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Repositories.DirectorioRepository;

@Service
public class DirectorioImpl implements DirectorioService {

    @Autowired
    private DirectorioRepository relacionDirectorioRepository;

    @Override
    public List<Directorio> findAll(){
        return (List<Directorio>) this.relacionDirectorioRepository.findAll();
    }

    @Override
    public Directorio save(Directorio relacionDirectorio){
        return this.relacionDirectorioRepository.save(relacionDirectorio);
    }
    
}
