package mx.gob.sev.api.LineaEducativaCiudadana.SeguimientoSolicitud.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import mx.gob.sev.api.LineaEducativaCiudadana.SeguimientoSolicitud.Models.SeguimientoSolicitud;
import mx.gob.sev.api.LineaEducativaCiudadana.SeguimientoSolicitud.Repositories.SeguimientoSolicitudRepository;

@RestController
@RequestMapping("api/SeguimientoSolicitud")
@CrossOrigin("*")

public class SeguimientoSolicitudController {
    
    @Autowired
    private SeguimientoSolicitudRepository seguimientoSolicitudRepository;

    @GetMapping
    @Transactional(readOnly = true)
    public List<SeguimientoSolicitud> findAll(){
        return this.seguimientoSolicitudRepository.findAll();
    }

    @PostMapping
    @Transactional
    public SeguimientoSolicitud save(@RequestBody SeguimientoSolicitud seguimientoSolicitud){
        return this.seguimientoSolicitudRepository.save(seguimientoSolicitud);
    }

}
