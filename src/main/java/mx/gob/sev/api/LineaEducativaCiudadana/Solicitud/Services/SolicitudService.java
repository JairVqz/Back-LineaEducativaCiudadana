package mx.gob.sev.api.LineaEducativaCiudadana.Solicitud.Services;

import java.util.List;

import mx.gob.sev.api.LineaEducativaCiudadana.Solicitud.Dto.SolicitudDTO;
import mx.gob.sev.api.LineaEducativaCiudadana.Solicitud.Models.Solicitud.SolicitudGeneral;
import mx.gob.sev.api.LineaEducativaCiudadana.Solicitud.Models.Solicitud.VistaSolicitud;

public interface SolicitudService {
    List<SolicitudGeneral> findAll();
    List<VistaSolicitud> findAllActive();
    List<VistaSolicitud> findAllActiveByRange(String fecha_inicio, String fecha_fin);
    List<VistaSolicitud> findAllActiveByRangeAndTramites(String fecha_inicio, String fecha_fin, List<Integer> idsTramites);
    SolicitudGeneral guardarSolicitud(SolicitudDTO dto);
    List<VistaSolicitud> findCoincidenciasSolicitud(String nombre, String apellidoPaterno, String apellidoMaterno);
    List<VistaSolicitud> findCoincidenciasInicio(String atributoBusqueda, String valorBusqueda);
}