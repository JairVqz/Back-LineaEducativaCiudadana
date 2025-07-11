package mx.gob.sev.api.LineaEducativaCiudadana.SeguimientoSolicitud.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.gob.sev.api.LineaEducativaCiudadana.SeguimientoSolicitud.Models.SeguimientoSolicitud;

@Service
public class SeguimientoSolicitudImpl implements SeguimientoSolicitudService {

    @Autowired
    private SeguimientoSolicitudImpl seguimientoSolicitudImpl;

    @Override
    public List<SeguimientoSolicitud> findAll(){
        return (List<SeguimientoSolicitud>) this.seguimientoSolicitudImpl.findAll();
    }

    @Override
    public SeguimientoSolicitud save(SeguimientoSolicitud seguimientoSolicitud){
        return this.seguimientoSolicitudImpl.save(seguimientoSolicitud);
    }
    
}
