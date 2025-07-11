package mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Models.Estructura;
import mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Services.Estructura.EstructuraImpl;

@RestController
@RequestMapping("api/Estructura")
@CrossOrigin("*")

public class EstructuraController {
    
    @Autowired
    private EstructuraImpl estructuraImpl;

    @GetMapping("/findAll")
    @Transactional(readOnly = true)
    public List<Estructura> findAll(){
        return this.estructuraImpl.findAll();
    }

    @PostMapping
    @Transactional
    public Estructura save(@RequestBody Estructura estructura){
        return this.estructuraImpl.save(estructura);
    }

}
