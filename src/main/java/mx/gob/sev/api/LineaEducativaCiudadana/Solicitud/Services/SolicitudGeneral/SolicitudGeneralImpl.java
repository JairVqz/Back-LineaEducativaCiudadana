package mx.gob.sev.api.LineaEducativaCiudadana.Solicitud.Services.SolicitudGeneral;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.gob.sev.api.LineaEducativaCiudadana.Solicitud.Models.SolicitudGeneral;
import mx.gob.sev.api.LineaEducativaCiudadana.Solicitud.Repositories.SolicitudGeneralRepository;

@Service
public class SolicitudGeneralImpl implements SolicituGeneralService{
    
    @Autowired
    private SolicitudGeneralRepository solicitudGeneralRepository;

    @Override
    public List<SolicitudGeneral> findAll(){
        return (List<SolicitudGeneral>) this.solicitudGeneralRepository.findAll();
    }

    @Override
    public List<SolicitudGeneral> findAllActive(){
        return (List<SolicitudGeneral>) this.solicitudGeneralRepository.findAllActive();
    }

    @Override
    public SolicitudGeneral save(SolicitudGeneral solicitudGeneral){
        return this.solicitudGeneralRepository.save(solicitudGeneral);
    }

}
