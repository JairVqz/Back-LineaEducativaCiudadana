package mx.gob.sev.api.LineaEducativaCiudadana.Solicitud.Services.Ubicacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.gob.sev.api.LineaEducativaCiudadana.Solicitud.Models.Ubicacion;
import mx.gob.sev.api.LineaEducativaCiudadana.Solicitud.Repositories.UbicacionRepository;

@Service
public class UbicacionImpl implements UbicacionService {

    @Autowired
    private UbicacionRepository ubicacionRepository;

    @Override
    public List<Ubicacion> findAll(){
        return (List<Ubicacion>) this.ubicacionRepository.findAll();
    }

    @Override
    public Ubicacion save(Ubicacion ubicacion){
        return this.ubicacionRepository.save(ubicacion);
    }
    
}
