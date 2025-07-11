package mx.gob.sev.api.LineaEducativaCiudadana.Solicitud.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import mx.gob.sev.api.LineaEducativaCiudadana.Solicitud.Models.Ubicacion;
import mx.gob.sev.api.LineaEducativaCiudadana.Solicitud.Services.Ubicacion.UbicacionImpl;

@RestController
@RequestMapping("api/Ubicacion")
@CrossOrigin("*")

public class UbicacionController {

    @Autowired
    private UbicacionImpl ubicacionImpl;

    @GetMapping("/findAll")
    @Transactional(readOnly = true)
    public List<Ubicacion> findAll(){
        return this.ubicacionImpl.findAll();
    }

    @PostMapping
    @Transactional
    public Ubicacion save(@RequestBody Ubicacion ubicacion){
        return this.ubicacionImpl.save(ubicacion);
    }
    
}
