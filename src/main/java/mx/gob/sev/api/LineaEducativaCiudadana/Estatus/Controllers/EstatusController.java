package mx.gob.sev.api.LineaEducativaCiudadana.Estatus.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import mx.gob.sev.api.LineaEducativaCiudadana.Estatus.Models.Estatus;
import mx.gob.sev.api.LineaEducativaCiudadana.Estatus.Services.EstatusImpl;

@RestController
@RequestMapping("/api/Estatus")
@CrossOrigin("*")

public class EstatusController {

    @Autowired
    private EstatusImpl estatusImpl;

    @GetMapping("/findAll")
    @Transactional(readOnly = true)
    public List<Estatus> findAll() {
        return estatusImpl.findAll();
    }

    @PostMapping
    @Transactional
    public Estatus save(@RequestBody Estatus estatus){
        return this.estatusImpl.save(estatus);
    }

    
}
