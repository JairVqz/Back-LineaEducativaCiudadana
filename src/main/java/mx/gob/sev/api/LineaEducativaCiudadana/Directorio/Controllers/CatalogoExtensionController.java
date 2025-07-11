package mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Models.CatalogoExtension;
import mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Services.CatalogoExtension.CatalogoExtensionImpl;

@RestController
@RequestMapping("api/CatalogoExtension")
@CrossOrigin("*")

public class CatalogoExtensionController {

    @Autowired
    private CatalogoExtensionImpl catalogoExtensionImpl;

    @GetMapping
    @Transactional(readOnly = true)
    public List<CatalogoExtension> findAll(){
        return this.catalogoExtensionImpl.findAll();
    }

    @PostMapping
    @Transactional
    public CatalogoExtension save(@RequestBody CatalogoExtension catalogoExtension){
        return this.catalogoExtensionImpl.save(catalogoExtension);
    }
    
}
