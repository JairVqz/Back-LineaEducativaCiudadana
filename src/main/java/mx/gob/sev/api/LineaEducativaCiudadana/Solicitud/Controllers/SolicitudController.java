package mx.gob.sev.api.LineaEducativaCiudadana.Solicitud.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import mx.gob.sev.api.LineaEducativaCiudadana.Solicitud.Dto.SolicitudDTO;
import mx.gob.sev.api.LineaEducativaCiudadana.Solicitud.Models.Solicitud.SolicitudGeneral;
import mx.gob.sev.api.LineaEducativaCiudadana.Solicitud.Services.SolicitudImpl;

@RestController
@RequestMapping("api/SolicitudGeneral")
@CrossOrigin("*")

public class SolicitudController {

    @Autowired
    private SolicitudImpl solicitudGeneralImpl;

    @GetMapping("/findAll")
    @Transactional(readOnly = true)
    public List<SolicitudGeneral> findAll() {
        return this.solicitudGeneralImpl.findAll();
    }

    @GetMapping("/findAllActive")
    @Transactional(readOnly = true)
    public List<SolicitudGeneral> findAllActive() {
        return this.solicitudGeneralImpl.findAllActive();
    }

    @PostMapping
    @Transactional
    public SolicitudGeneral save(@RequestBody SolicitudDTO solicitudDTO) {
        return this.solicitudGeneralImpl.guardarSolicitud(solicitudDTO);
    }

}
