package mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Models.RelacionDirectorio;
import mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Services.RelacionDirectorio.RelacionDirectorioImpl;

@RestController
@RequestMapping("api/RelacionDirectorio")
@CrossOrigin("*")

public class RelacionDirectorioController {
    
    @Autowired
    private RelacionDirectorioImpl relacionDirectorioImpl;

    @GetMapping("/findAll")
    @Transactional(readOnly = true)
    public List<RelacionDirectorio> findAll(){
        return this.relacionDirectorioImpl.findAll();
    }

    @PostMapping
    @Transactional
    public RelacionDirectorio save(@RequestBody RelacionDirectorio relacionDirectorio){
        return this.relacionDirectorioImpl.save(relacionDirectorio);
    }


}
