package mx.gob.sev.api.LineaEducativaCiudadana.Usuario.Services.RelacionAcceso;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.gob.sev.api.LineaEducativaCiudadana.Usuario.Models.RelacionAcceso;
import mx.gob.sev.api.LineaEducativaCiudadana.Usuario.Repositories.RelacionAccesoRepository;

@Service
public class RelacionAccesoImpl implements RelacionAccesoService {

    @Autowired
    private RelacionAccesoRepository relacionAccesoRepository;

    @Override
    public List<RelacionAcceso> findAll(){
        return (List<RelacionAcceso>) this.relacionAccesoRepository.findAll();
    }

    @Override
    public RelacionAcceso save(RelacionAcceso relacionAcceso){
        return this.relacionAccesoRepository.save(relacionAcceso);
    }
    
}
