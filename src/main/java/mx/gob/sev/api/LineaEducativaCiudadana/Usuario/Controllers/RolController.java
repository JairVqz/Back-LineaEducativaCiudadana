package mx.gob.sev.api.LineaEducativaCiudadana.Usuario.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import jakarta.persistence.EntityNotFoundException;
import mx.gob.sev.api.LineaEducativaCiudadana.Usuario.Models.Rol;
import mx.gob.sev.api.LineaEducativaCiudadana.Usuario.Services.Rol.RolImpl;

@RestController
@RequestMapping("api/Rol")
@CrossOrigin("*")

public class RolController {
    @Autowired
    private RolImpl rolImpl;

    @GetMapping("/findAll")
    @Transactional(readOnly = true)
    public List<Rol> findAll() {
        return this.rolImpl.findAll();
    }

    @GetMapping("/findAllActive")
    @Transactional(readOnly = true)
    public List<Rol> findAllActive() {
        return this.rolImpl.findAllActive();
    }

    @GetMapping("/findAllInactive")
    @Transactional(readOnly = true)
    public List<Rol> findAllInactive() {
        return this.rolImpl.findAllInactive();
    }

    @GetMapping("/findById")
    @Transactional(readOnly = true)
    public ResponseEntity<?> findById(@RequestParam Long idRol) {
        try {
            Rol rol = this.rolImpl.findById(idRol);
            return ResponseEntity.ok(rol);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping
    @Transactional
    public Rol save(@RequestBody Rol rol) {
        return this.rolImpl.save(rol);
    }

    @PutMapping()
    @Transactional
    public ResponseEntity<Rol> update(@RequestBody Rol rol) {
        try {
            Rol actualizado = rolImpl.update(rol);
            return ResponseEntity.ok(actualizado);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
