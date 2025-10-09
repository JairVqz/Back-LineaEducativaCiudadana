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
import mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Models.CatalogoTramite;
import mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Services.CatalogoTramite.CatalogoTramiteImpl;

@RestController
@RequestMapping("api/Catalogo/Tramite")
@CrossOrigin("*")

public class CatalogoTramiteController {

    @Autowired
    private CatalogoTramiteImpl catalogoTramiteImpl;

    @GetMapping("/findAll")
    @Transactional(readOnly = true)
    public List<CatalogoTramite> findAll() {
        return this.catalogoTramiteImpl.findAll();
    }

    @GetMapping("/findAllActive")
    @Transactional(readOnly = true)
    public List<CatalogoTramite> findAllActive() {
        return this.catalogoTramiteImpl.findAllActive();
    }

    @GetMapping("/findAllInactive")
    @Transactional(readOnly = true)
    public List<CatalogoTramite> findAllInactive() {
        return this.catalogoTramiteImpl.findAllInactive();
    }

    @GetMapping("/findById")
    @Transactional(readOnly = true)
    public ResponseEntity<?> findById(@RequestParam Long idTramite) {
        try {
            CatalogoTramite catalogoTramite = this.catalogoTramiteImpl.findById(idTramite);
            return ResponseEntity.ok(catalogoTramite);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/findTramiteByArea")
    @Transactional(readOnly = true)
    public List<CatalogoTramite> findTramiteByArea(@RequestParam Long idArea) {
        return this.catalogoTramiteImpl.findTramiteByArea(idArea);
    }

    @PostMapping
    @Transactional
    public CatalogoTramite save(@RequestBody CatalogoTramite catalogoTramite) {
        return this.catalogoTramiteImpl.save(catalogoTramite);
    }

    @PutMapping()
    @Transactional
    public ResponseEntity<CatalogoTramite> update(@RequestBody CatalogoTramite catalogoTramite) {
        try {
            CatalogoTramite actualizado = catalogoTramiteImpl.update(catalogoTramite);
            return ResponseEntity.ok(actualizado);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/findAllActiveTramitesByUsuario")
    @Transactional(readOnly = true)
    public List<CatalogoTramite> findAllActiveTramitesByUsuario(
            @RequestParam List<Integer> idsTramites) {
        return catalogoTramiteImpl.findAllActiveTramitesByUsuario(idsTramites);
    }

}
