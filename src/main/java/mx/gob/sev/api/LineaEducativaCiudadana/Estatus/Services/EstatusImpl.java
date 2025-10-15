package mx.gob.sev.api.LineaEducativaCiudadana.Estatus.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.gob.sev.api.LineaEducativaCiudadana.Estatus.Models.Estatus;
import mx.gob.sev.api.LineaEducativaCiudadana.Estatus.Repositories.EstatusRepository;

@Service
public class EstatusImpl implements EstatusService{
    
    @Autowired
    private EstatusRepository estatusRepository;

    @Override
    public List<Estatus> findAll() {
        return (List<Estatus>) estatusRepository.findAll();
    }

    @Override
    public Estatus save(Estatus estatus){
        return this.estatusRepository.save(estatus);
    }

    @Override
    public List<Estatus> findAllActive() {
        return estatusRepository.findAllActive();
    }

}
