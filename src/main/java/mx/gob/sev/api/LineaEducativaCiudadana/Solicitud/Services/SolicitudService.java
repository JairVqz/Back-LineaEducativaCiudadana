package mx.gob.sev.api.LineaEducativaCiudadana.Solicitud.Services;

import java.util.List;

import mx.gob.sev.api.LineaEducativaCiudadana.Solicitud.Dto.SolicitudDTO;
import mx.gob.sev.api.LineaEducativaCiudadana.Solicitud.Models.Solicitud.SolicitudGeneral;

public interface SolicitudService {
    List<SolicitudGeneral> findAll();
    List<SolicitudGeneral> findAllActive();
    SolicitudGeneral guardarSolicitud(SolicitudDTO dto);
}

