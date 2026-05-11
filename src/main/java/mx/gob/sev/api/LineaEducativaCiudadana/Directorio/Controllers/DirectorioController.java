package mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Models.Directorio;
import mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Models.DirectorioDTO;
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

    @GetMapping("/findAllVistaDActivo")
    @Transactional(readOnly = true)
    public ResponseEntity<List<VistaDirectorio>> findAllVistaDActivo() {
        List<VistaDirectorio> resultados = relacionDirectorioImpl.findAllVistaDActivo();
        if (resultados.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(resultados);
    }

    @GetMapping("/findAllVistaDInactivo")
    @Transactional(readOnly = true)
    public ResponseEntity<List<VistaDirectorio>> findAllVistaDInactivo() {
        List<VistaDirectorio> resultados = relacionDirectorioImpl.findAllVistaDInactivo();
        if (resultados.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(resultados);
    }

    @GetMapping("/findTramitesByAreaActivo")
    @Transactional(readOnly = true)
    public ResponseEntity<List<VistaDirectorio>> findTramitesByAreaActivo(@RequestParam Long idArea) {
        List<VistaDirectorio> resultados = relacionDirectorioImpl.findTramitesByAreaActivo(idArea);
        if (resultados.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(resultados);
    }

    @GetMapping("/findTramitesByAreaInactivo")
    @Transactional(readOnly = true)
    public ResponseEntity<List<VistaDirectorio>> findTramitesByAreaInactivo(@RequestParam Long idArea) {
        List<VistaDirectorio> resultados = relacionDirectorioImpl.findTramitesByAreaInactivo(idArea);
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

    @PutMapping("/reactivateByIdDirectorio")
    @Transactional
    public ResponseEntity<?> reactivateByIdDirectorio(@RequestParam Long id) {
        try {
            relacionDirectorioImpl.reactivateByIdDirectorio(id);
            return ResponseEntity.ok("Directorio reactivado con éxito");
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @PutMapping("/desactivateByIdDirectorio")
    @Transactional
    public ResponseEntity<?> desactivateByIdDirectorio(@RequestParam Long id) {
        try {
            relacionDirectorioImpl.desactivateByIdDirectorio(id);
            return ResponseEntity.ok("Directorio desactivado con éxito");
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @PostMapping("/guardar")
    public ResponseEntity<?> guardar(@RequestBody DirectorioDTO dto) {
        try {
            Directorio directorio = relacionDirectorioImpl.guardar(dto);
            return ResponseEntity.status(HttpStatus.CREATED).body(directorio);

        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

}
