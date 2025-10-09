package mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Models.Directorio;
import mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Models.VistaDirectorio;
import mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Services.Directorio.DirectorioImpl;

@RestController
@RequestMapping("api/RelacionDirectorio")
@CrossOrigin("*")

public class DirectorioController {

    @Autowired
    private DirectorioImpl relacionDirectorioImpl;

    @GetMapping("/findAll")
    @Transactional(readOnly = true)
    public List<Directorio> findAll() {
        return this.relacionDirectorioImpl.findAll();
    }

    @PostMapping
    @Transactional
    public Directorio save(@RequestBody Directorio relacionDirectorio) {
        return this.relacionDirectorioImpl.save(relacionDirectorio);
    }

    @GetMapping("/findAllVistaD")
    @Transactional(readOnly = true)
    public ResponseEntity<List<VistaDirectorio>> findAllVistaD() {
        List<VistaDirectorio> resultados = relacionDirectorioImpl.findAllVistaD();
        if (resultados.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(resultados);
    }

    @GetMapping("/findTramitesByArea")
    @Transactional(readOnly = true)
    public ResponseEntity<List<VistaDirectorio>> findTramitesByArea(@RequestParam Long idArea) {
        List<VistaDirectorio> resultados = relacionDirectorioImpl.findTramitesByArea(idArea);
        if (resultados.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(resultados);
    }

    @GetMapping("/findAllExtensiones")
    @Transactional(readOnly = true)
    public ResponseEntity<List<Map<String, Object>>> findAllExtensiones() {
        List<Map<String, Object>> resultados = relacionDirectorioImpl.findAllExtensiones();
        if (resultados.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(resultados);
    }

}
