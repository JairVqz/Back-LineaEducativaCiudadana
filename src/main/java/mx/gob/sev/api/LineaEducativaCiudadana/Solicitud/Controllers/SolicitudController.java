package mx.gob.sev.api.LineaEducativaCiudadana.Solicitud.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import mx.gob.sev.api.LineaEducativaCiudadana.Solicitud.Dto.SolicitudDTO;
import mx.gob.sev.api.LineaEducativaCiudadana.Solicitud.Models.Solicitud.SolicitudGeneral;
import mx.gob.sev.api.LineaEducativaCiudadana.Solicitud.Models.Solicitud.VistaSolicitud;
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
    public ResponseEntity<List<VistaSolicitud>> findAllActive() {
        List<VistaSolicitud> resultados = this.solicitudGeneralImpl.findAllActive();
        if (resultados.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(resultados);
    }

    @GetMapping("/findAllActiveByRange")
    @Transactional(readOnly = true)
    public ResponseEntity<List<VistaSolicitud>> findAllActiveByRange(@RequestParam String fecha_inicio,
            @RequestParam String fecha_fin) {
        List<VistaSolicitud> resultados = this.solicitudGeneralImpl.findAllActiveByRange(fecha_inicio, fecha_fin);
        if (resultados.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(resultados);
    }

    @GetMapping("/findAllActiveByRangeAndTramites")
    @Transactional(readOnly = true)
    public ResponseEntity<List<VistaSolicitud>> findAllActiveByRangeAndTramites(@RequestParam String fecha_inicio,
            @RequestParam String fecha_fin, @RequestParam List<Integer> idsTramites) {
        List<VistaSolicitud> resultados = this.solicitudGeneralImpl.findAllActiveByRangeAndTramites(fecha_inicio,
                fecha_fin, idsTramites);
        if (resultados.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(resultados);
    }

    @PostMapping
    @Transactional
    public SolicitudGeneral save(@RequestBody SolicitudDTO solicitudDTO) {
        return this.solicitudGeneralImpl.guardarSolicitud(solicitudDTO);
    }

    @GetMapping("/findCoincidenciasSolicitud")
    @Transactional(readOnly = true)
    public ResponseEntity<List<VistaSolicitud>> findCoincidenciasSolicitud(@RequestParam String nombre,
            @RequestParam String apellidoPaterno, @RequestParam String apellidoMaterno) {
        List<VistaSolicitud> resultados = this.solicitudGeneralImpl.findCoincidenciasSolicitud(nombre, apellidoPaterno,
                apellidoMaterno);
        if (resultados.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(resultados);
    }

}
