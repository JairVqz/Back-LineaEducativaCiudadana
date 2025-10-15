package mx.gob.sev.api.LineaEducativaCiudadana.SeguimientoSolicitud.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.gob.sev.api.LineaEducativaCiudadana.SeguimientoSolicitud.Models.SeguimientoSolicitud;
import mx.gob.sev.api.LineaEducativaCiudadana.SeguimientoSolicitud.Repositories.SeguimientoSolicitudRepository;

@Service
public class SeguimientoSolicitudImpl implements SeguimientoSolicitudService {

    @Autowired
    private SeguimientoSolicitudRepository seguimientoSolicitudRepository;

    @Override
    public List<SeguimientoSolicitud> findAll(){
        return (List<SeguimientoSolicitud>) this.seguimientoSolicitudRepository.findAll();
    }

    @Override
    public SeguimientoSolicitud save(SeguimientoSolicitud seguimientoSolicitud){
        return this.seguimientoSolicitudRepository.save(seguimientoSolicitud);
    }

    @Override
    public List<SeguimientoSolicitud> findAllByIdSolicitud(Long idSolicitud){
        return this.seguimientoSolicitudRepository.findAllByIdSolicitud(idSolicitud);
    }   
    
}
