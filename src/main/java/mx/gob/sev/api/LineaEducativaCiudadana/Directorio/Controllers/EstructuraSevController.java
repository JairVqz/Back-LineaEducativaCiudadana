package mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

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
    public List<EstructuraSev> findAll(){
        return this.estructuraSevImpl.findAll();
    }

    @PostMapping
    @Transactional
    public EstructuraSev save(@RequestBody EstructuraSev estructuraSev){
        return this.estructuraSevImpl.save(estructuraSev);
    }

}
