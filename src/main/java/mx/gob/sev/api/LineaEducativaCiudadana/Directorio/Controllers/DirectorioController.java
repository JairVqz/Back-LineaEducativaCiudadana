package mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Models.Directorio;
import mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Services.Directorio.DirectorioImpl;

@RestController
@RequestMapping("api/RelacionDirectorio")
@CrossOrigin("*")

public class DirectorioController {
    
    @Autowired
    private DirectorioImpl relacionDirectorioImpl;

    @GetMapping("/findAll")
    @Transactional(readOnly = true)
    public List<Directorio> findAll(){
        return this.relacionDirectorioImpl.findAll();
    }

    @PostMapping
    @Transactional
    public Directorio save(@RequestBody Directorio relacionDirectorio){
        return this.relacionDirectorioImpl.save(relacionDirectorio);
    }


}
