package mx.gob.sev.api.LineaEducativaCiudadana.Solicitud.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import mx.gob.sev.api.LineaEducativaCiudadana.Solicitud.Models.SolicitudGeneral;
import mx.gob.sev.api.LineaEducativaCiudadana.Solicitud.Services.SolicitudGeneral.SolicitudGeneralImpl;

@RestController
@RequestMapping("api/SolicitudGeneral")
@CrossOrigin("*")

public class SolicitudGeneralController {

    @Autowired
    private SolicitudGeneralImpl solicitudGeneralImpl;

    @GetMapping("/findAll")
    @Transactional(readOnly = true)
    public List<SolicitudGeneral> findAll(){
        return this.solicitudGeneralImpl.findAll();
    }

    @PostMapping
    @Transactional
    public SolicitudGeneral save(@RequestBody SolicitudGeneral solicitudGeneral){
        return this.solicitudGeneralImpl.save(solicitudGeneral);
    }
    
}
