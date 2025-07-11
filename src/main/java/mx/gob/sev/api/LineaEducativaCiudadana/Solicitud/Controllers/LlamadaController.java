package mx.gob.sev.api.LineaEducativaCiudadana.Solicitud.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import mx.gob.sev.api.LineaEducativaCiudadana.Solicitud.Models.Llamada;
import mx.gob.sev.api.LineaEducativaCiudadana.Solicitud.Services.Llamada.LlamadaImpl;

@RestController
@RequestMapping("api/Llamada")
@CrossOrigin("*")

public class LlamadaController {

    @Autowired
    private LlamadaImpl llamadaImpl;

    @GetMapping("/findAll")
    @Transactional(readOnly = true)
    public List<Llamada> findAll(){
        return this.llamadaImpl.findAll();
    }

    @PostMapping()
    @Transactional
    public Llamada save(@RequestBody Llamada llamada){
        return this.llamadaImpl.save(llamada);
    }
    
}
