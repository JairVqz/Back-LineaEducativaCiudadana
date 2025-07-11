package mx.gob.sev.api.LineaEducativaCiudadana.SeguimientoSolicitud.Services;

import java.util.List;

import mx.gob.sev.api.LineaEducativaCiudadana.SeguimientoSolicitud.Models.SeguimientoSolicitud;

public interface SeguimientoSolicitudService {

    List<SeguimientoSolicitud> findAll();
    SeguimientoSolicitud save(SeguimientoSolicitud seguimientoSolicitud);
    
}
