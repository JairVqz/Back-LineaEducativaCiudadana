package mx.gob.sev.api.LineaEducativaCiudadana.Estatus.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.gob.sev.api.LineaEducativaCiudadana.Estatus.Models.Estatus;
import mx.gob.sev.api.LineaEducativaCiudadana.Estatus.Services.EstatusService;

@RestController
@RequestMapping("/api/Estatus")
@CrossOrigin(origins = "*")
public class EstatusController {

    @Autowired
    private EstatusService estatusService;

    @GetMapping("/findAll")
    public List<Estatus> findAll() {
        return estatusService.findAll();
    }
    
}
