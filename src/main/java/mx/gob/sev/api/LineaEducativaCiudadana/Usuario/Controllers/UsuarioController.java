package mx.gob.sev.api.LineaEducativaCiudadana.Usuario.Controllers;

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
import mx.gob.sev.api.LineaEducativaCiudadana.Usuario.Models.Usuario;
import mx.gob.sev.api.LineaEducativaCiudadana.Usuario.Models.VistaUsuario;
import mx.gob.sev.api.LineaEducativaCiudadana.Usuario.Services.Usuario.UsuarioImpl;

@RestController
@RequestMapping("api/Usuario")
@CrossOrigin("*")

public class UsuarioController {

    @Autowired
    private UsuarioImpl usuarioImpl;

    @GetMapping("/findAll")
    @Transactional(readOnly = true)
    public List<Usuario> findAll() {
        return this.usuarioImpl.findAll();
    }

    @GetMapping("/findAllActive")
    @Transactional(readOnly = true)
    public List<Usuario> findAllActive() {
        return this.usuarioImpl.findAllActive();
    }

    @GetMapping("/findAllInactive")
    @Transactional(readOnly = true)
    public List<Usuario> findAllInactive() {
        return this.usuarioImpl.findAllInactive();
    }

    @GetMapping("/findById")
    @Transactional(readOnly = true)
    public ResponseEntity<?> findById(@RequestParam Long id) {
        try {
            Usuario usuario = this.usuarioImpl.findById(id);
            return ResponseEntity.ok(usuario);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping
    @Transactional
    public Usuario save(@RequestBody Usuario usuario) {
        return this.usuarioImpl.save(usuario);
    }

    @PutMapping()
    @Transactional
    public ResponseEntity<Usuario> update(@RequestBody Usuario usuario) {
        try {
            Usuario actualizado = usuarioImpl.update(usuario);
            return ResponseEntity.ok(actualizado);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/validateLogin")
    @Transactional(readOnly = true)
    public ResponseEntity<?> validateLogin(@RequestParam String email) {
        try {
            Usuario usuario = this.usuarioImpl.validateLogin(email);
            return ResponseEntity.ok(usuario);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/findAllVistaU")
    @Transactional(readOnly = true)
    public ResponseEntity<List<VistaUsuario>> findAllVistaU() {
        List<VistaUsuario> resultados = usuarioImpl.findAllVistaU();
        if (resultados.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(resultados);
    }

    @GetMapping("/findAllConAccesos")
    public List<Usuario> findAllConAccesos() {
        return usuarioImpl.findAllConAccesos();
    }

}
