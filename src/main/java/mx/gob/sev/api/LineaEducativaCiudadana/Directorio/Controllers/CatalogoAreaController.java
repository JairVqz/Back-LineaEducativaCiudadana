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
import mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Models.CatalogoArea;
import mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Services.Estructura.CatalogoAreaImpl;

@RestController
@RequestMapping("api/Catalogo/Area")
@CrossOrigin("*")

public class CatalogoAreaController {

    @Autowired
    private CatalogoAreaImpl catalogoAreaImpl;

    @GetMapping("/findAll")
    @Transactional(readOnly = true)
    public List<CatalogoArea> findAll() {
        return this.catalogoAreaImpl.findAll();
    }

    @GetMapping("/findAllActive")
    @Transactional(readOnly = true)
    public List<CatalogoArea> findAllActive() {
        return this.catalogoAreaImpl.findAllActive();
    }

    @GetMapping("/findAllInactive")
    @Transactional(readOnly = true)
    public List<CatalogoArea> findAllInactive() {
        return this.catalogoAreaImpl.findAllInactive();
    }

    @GetMapping("/findById")
    @Transactional(readOnly = true)
    public ResponseEntity<?> findById(@RequestParam Long idArea) {
        try {
            CatalogoArea catalogoArea = this.catalogoAreaImpl.findById(idArea);
            return ResponseEntity.ok(catalogoArea);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping
    @Transactional
    public CatalogoArea save(@RequestBody CatalogoArea catalogoArea) {
        return this.catalogoAreaImpl.save(catalogoArea);
    }

    @PutMapping()
    @Transactional
    public ResponseEntity<CatalogoArea> update(@RequestBody CatalogoArea catalogoArea) {
        try {
            CatalogoArea actualizado = catalogoAreaImpl.update(catalogoArea);
            return ResponseEntity.ok(actualizado);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
