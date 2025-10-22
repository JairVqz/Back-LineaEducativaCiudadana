package mx.gob.sev.api.LineaEducativaCiudadana.Solicitud.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.persistence.EntityNotFoundException;
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

    @GetMapping("/findAllActiveByRangeAndArea")
    @Transactional(readOnly = true)
    public ResponseEntity<List<VistaSolicitud>> findAllActiveByRangeAndArea(@RequestParam String fecha_inicio,
            @RequestParam String fecha_fin, @RequestParam Long idArea) {
        List<VistaSolicitud> resultados = this.solicitudGeneralImpl.findAllActiveByRangeAndArea(fecha_inicio,
                fecha_fin, idArea);
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

    @GetMapping("/findCoincidenciasInicio")
    @Transactional(readOnly = true)
    public ResponseEntity<List<VistaSolicitud>> findCoincidenciasInicio(@RequestParam String atributoBusqueda,
            @RequestParam String valorBusqueda) {
        List<VistaSolicitud> resultados = this.solicitudGeneralImpl.findCoincidenciasInicio(atributoBusqueda,
                valorBusqueda);
        if (resultados.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(resultados);
    }

    @PutMapping("/cambiarEstatusSolicitud")
    @Transactional
    public ResponseEntity<?> cambiarEstatusSolicitud(@RequestParam Long idSolicitud, @RequestParam Long idEstatus) {
        try {
            this.solicitudGeneralImpl.cambiarEstatusSolicitud(idSolicitud, idEstatus);
            return ResponseEntity.ok().body("Estatus actualizado");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PutMapping("/redirigirSolicitud")
    @Transactional
    public ResponseEntity<?> redirigirSolicitud(@RequestParam Long idSolicitud, @RequestParam Long idDirectorio) {
        try {
            this.solicitudGeneralImpl.redirigirSolicitud(idSolicitud, idDirectorio);
            return ResponseEntity.ok().body("Estatus actualizado");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/actualizarDiasTranscurridos")
    public ResponseEntity<?> ActualizarDiasTranscurridos() {
        String result = solicitudGeneralImpl.ActualizarDiasTranscurridos();
        return ResponseEntity.ok(result);
    }
}
