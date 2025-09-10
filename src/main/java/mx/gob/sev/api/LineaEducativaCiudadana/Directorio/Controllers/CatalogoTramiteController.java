package mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Models.CatalogoTramite;
import mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Services.CatalogoTramite.CatalogoTramiteImpl;

@RestController
@RequestMapping("api/CatalogoTramite")
@CrossOrigin("*")

public class CatalogoTramiteController {

    @Autowired
    private CatalogoTramiteImpl catalogoTramiteImpl;

    @GetMapping("/findAll")
    @Transactional(readOnly = true)
    public List<CatalogoTramite> findAll(){
        return this.catalogoTramiteImpl.findAll();
    }

    @PostMapping
    @Transactional
    public CatalogoTramite save(@RequestBody CatalogoTramite catalogoTramite){
        return this.catalogoTramiteImpl.save(catalogoTramite);
    }
    
}
