package mx.gob.sev.api.LineaEducativaCiudadana.Prioridad.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.gob.sev.api.LineaEducativaCiudadana.Prioridad.Models.Prioridad;
import mx.gob.sev.api.LineaEducativaCiudadana.Prioridad.Repositories.PrioridadRepository;

@Service
public class PrioridadImpl implements PrioridadService {

    @Autowired
    private PrioridadRepository prioridadRepository;

    @Override
    public List<Prioridad> findAll() {
        return (List<Prioridad>) prioridadRepository.findAll();
    }
    
}
