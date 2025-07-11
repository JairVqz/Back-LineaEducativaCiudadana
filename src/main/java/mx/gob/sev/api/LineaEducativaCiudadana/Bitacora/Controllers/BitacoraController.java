package mx.gob.sev.api.LineaEducativaCiudadana.Bitacora.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import mx.gob.sev.api.LineaEducativaCiudadana.Bitacora.Models.Bitacora;
import mx.gob.sev.api.LineaEducativaCiudadana.Bitacora.Services.BitacoraImpl;

@RestController
@RequestMapping("api/Bitacora")
@CrossOrigin("*")

public class BitacoraController {

    @Autowired
    private BitacoraImpl bitacoraImpl;

    @GetMapping("/findAll")
    @Transactional(readOnly = true)
    public List<Bitacora> findAll(){
        return this.bitacoraImpl.findAll();
    }
    
    @PostMapping
    @Transactional
    public Bitacora save(@RequestBody Bitacora bitacora){
        return this.bitacoraImpl.save(bitacora);
    }
    
}
