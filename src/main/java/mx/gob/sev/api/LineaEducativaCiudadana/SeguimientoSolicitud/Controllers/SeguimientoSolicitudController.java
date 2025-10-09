package mx.gob.sev.api.LineaEducativaCiudadana.SeguimientoSolicitud.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mx.gob.sev.api.LineaEducativaCiudadana.SeguimientoSolicitud.Models.SeguimientoSolicitud;
import mx.gob.sev.api.LineaEducativaCiudadana.SeguimientoSolicitud.Services.SeguimientoSolicitudImpl;

@RestController
@RequestMapping("api/SeguimientoSolicitud")
@CrossOrigin("*")

public class SeguimientoSolicitudController {

    @Autowired
    private SeguimientoSolicitudImpl seguimientoSolicitudImpl;

    @GetMapping
    @Transactional(readOnly = true)
    public List<SeguimientoSolicitud> findAll() {
        return this.seguimientoSolicitudImpl.findAll();
    }

    @PostMapping
    @Transactional
    public SeguimientoSolicitud save(@RequestBody SeguimientoSolicitud seguimientoSolicitud) {
        return this.seguimientoSolicitudImpl.save(seguimientoSolicitud);
    }

    @GetMapping("/findAllByIdSolicitud")
    public List<SeguimientoSolicitud> findAllByIdSolicitud(@RequestParam Long idSolicitud) {
        return this.seguimientoSolicitudImpl.findAllByIdSolicitud(idSolicitud);
    }

}
