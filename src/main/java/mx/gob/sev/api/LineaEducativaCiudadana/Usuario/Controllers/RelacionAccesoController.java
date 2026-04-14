package mx.gob.sev.api.LineaEducativaCiudadana.Usuario.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import jakarta.persistence.EntityNotFoundException;
import mx.gob.sev.api.LineaEducativaCiudadana.Usuario.Models.RelacionAcceso;
import mx.gob.sev.api.LineaEducativaCiudadana.Usuario.Services.RelacionAcceso.RelacionAccesoImpl;

@RestController
@RequestMapping("api/RelacionAcceso")
@CrossOrigin("*")

public class RelacionAccesoController {

    @Autowired
    private RelacionAccesoImpl relacionAccesoImpl;

    @GetMapping("/findAll")
    @Transactional(readOnly = true)
    public List<RelacionAcceso> findAll() {
        return this.relacionAccesoImpl.findAll();
    }

    @PostMapping("/save")
    @Transactional
    public RelacionAcceso save(@RequestBody RelacionAcceso relacionAcceso) {
        return this.relacionAccesoImpl.save(relacionAcceso);
    }

    @GetMapping("/findDirectorioByUsuario")
    @Transactional(readOnly = true)
    public List<RelacionAcceso> findDirectorioByUsuario(@RequestParam Long idUsuario) {
        return this.relacionAccesoImpl.findDirectorioByUsuario(idUsuario);
    }

    @PutMapping("/desasignarTramite")
    @Transactional
    public ResponseEntity<?> reactiveById(@RequestParam Long idAcceso) {
        try {
            this.relacionAccesoImpl.desasignarTramite(idAcceso);
            return ResponseEntity.ok().body("RelaciónTramite marcada como inactiva.");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

}
