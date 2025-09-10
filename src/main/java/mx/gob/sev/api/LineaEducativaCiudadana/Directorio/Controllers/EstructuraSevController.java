package mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Controllers;

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
import mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Models.EstructuraSev;
import mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Services.Estructura.EstructuraSevImpl;

@RestController
@RequestMapping("api/Estructura")
@CrossOrigin("*")

public class EstructuraSevController {

    @Autowired
    private EstructuraSevImpl estructuraSevImpl;

    @GetMapping("/findAll")
    @Transactional(readOnly = true)
    public List<EstructuraSev> findAll() {
        return this.estructuraSevImpl.findAll();
    }

    @GetMapping("/findAllActive")
    @Transactional(readOnly = true)
    public List<EstructuraSev> findAllActive() {
        return this.estructuraSevImpl.findAllActive();
    }

    @GetMapping("/findAllInactive")
    @Transactional(readOnly = true)
    public List<EstructuraSev> findAllInactive() {
        return this.estructuraSevImpl.findAllInactive();
    }

    @GetMapping("/findById")
    @Transactional(readOnly = true)
    public ResponseEntity<?> findById(@RequestParam Long idEstructura) {
        try {
            EstructuraSev estructuraSev = this.estructuraSevImpl.findById(idEstructura);
            return ResponseEntity.ok(estructuraSev);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping
    @Transactional
    public EstructuraSev save(@RequestBody EstructuraSev estructuraSev) {
        return this.estructuraSevImpl.save(estructuraSev);
    }

    @PutMapping()
    @Transactional
    public ResponseEntity<EstructuraSev> update(@RequestBody EstructuraSev estructuraSev) {
        try {
            EstructuraSev actualizado = estructuraSevImpl.update(estructuraSev);
            return ResponseEntity.ok(actualizado);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
