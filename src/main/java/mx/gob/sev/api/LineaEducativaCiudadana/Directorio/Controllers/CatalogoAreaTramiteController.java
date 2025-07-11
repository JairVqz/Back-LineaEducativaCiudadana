package mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Models.CatalogoAreaTramite;
import mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Services.CatalogoAreaTramite.CatalogoAreaTramiteImpl;

@RestController
@RequestMapping("api/CatalogoAreaTramite")
@CrossOrigin("*")

public class CatalogoAreaTramiteController {

    @Autowired
    private CatalogoAreaTramiteImpl catalogoAreaTramiteImpl;

    @GetMapping("/findAll")
    @Transactional(readOnly = true)
    public List<CatalogoAreaTramite> findAll(){
        return this.catalogoAreaTramiteImpl.findAll();
    }

    @PostMapping
    @Transactional
    public CatalogoAreaTramite save(@RequestBody CatalogoAreaTramite catalogoAreaTramite){
        return this.catalogoAreaTramiteImpl.save(catalogoAreaTramite);
    }
    
}
