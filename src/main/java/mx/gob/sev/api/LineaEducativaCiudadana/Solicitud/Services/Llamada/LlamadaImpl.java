package mx.gob.sev.api.LineaEducativaCiudadana.Solicitud.Services.Llamada;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.gob.sev.api.LineaEducativaCiudadana.Solicitud.Models.Llamada;
import mx.gob.sev.api.LineaEducativaCiudadana.Solicitud.Repositories.LlamadaRepository;

@Service
public class LlamadaImpl implements LlamadaService {

    @Autowired
    private LlamadaRepository llamadaRepository;

    @Override
    public List<Llamada> findAll(){
        return (List<Llamada>) this.llamadaRepository.findAll();
    }

    @Override
    public Llamada save(Llamada llamada){
        return this.llamadaRepository.save(llamada);
    }
    
}