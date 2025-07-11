package mx.gob.sev.api.LineaEducativaCiudadana.Solicitud.Services.SolicitudGeneral;

import java.util.List;

import mx.gob.sev.api.LineaEducativaCiudadana.Solicitud.Models.SolicitudGeneral;

public interface SolicituGeneralService {
    
    List<SolicitudGeneral> findAll();
    SolicitudGeneral save(SolicitudGeneral solicitudGeneral);

}
