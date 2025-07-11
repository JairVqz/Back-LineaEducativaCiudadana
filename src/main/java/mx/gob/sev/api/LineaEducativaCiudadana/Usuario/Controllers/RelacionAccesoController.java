package mx.gob.sev.api.LineaEducativaCiudadana.Usuario.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import mx.gob.sev.api.LineaEducativaCiudadana.Usuario.Models.RelacionAcceso;
import mx.gob.sev.api.LineaEducativaCiudadana.Usuario.Services.RelacionAcceso.RelacionAccesoImpl;

@RestController
@RequestMapping("api/RelacionAcceso")
@CrossOrigin("*")

public class RelacionAccesoController {

    @Autowired
    private RelacionAccesoImpl relacionAccesoImpl;

    @GetMapping("/findAll")
    @Transactional(readOnly = true)
    public List<RelacionAcceso> findAll(){
        return this.relacionAccesoImpl.findAll();
    }

    @PostMapping
    @Transactional
    public RelacionAcceso save(@RequestBody RelacionAcceso relacionAcceso){
        return this.relacionAccesoImpl.save(relacionAcceso);
    }
    
}
