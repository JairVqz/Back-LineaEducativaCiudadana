package mx.gob.sev.api.LineaEducativaCiudadana.Bitacora.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.gob.sev.api.LineaEducativaCiudadana.Bitacora.Models.Bitacora;
import mx.gob.sev.api.LineaEducativaCiudadana.Bitacora.Repositories.BitacoraRepository;

@Service
public class BitacoraImpl implements BitacoraService {

    @Autowired
    private BitacoraRepository bitacoraRepository;

    @Override
    public List<Bitacora> findAll(){
        return (List<Bitacora>) this.bitacoraRepository.findAll();
    }

    @Override
    public Bitacora save(Bitacora bitacora){
        return this.bitacoraRepository.save(bitacora);
    }
    
}
