package mx.gob.sev.api.LineaEducativaCiudadana.Estatus.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public Estatus save(@RequestBody Estatus estatus) {
        return this.estatusImpl.save(estatus);
    }

    @GetMapping("/findAllActive")
    @Transactional(readOnly = true)
    public List<Estatus> findAllActive() {
        return estatusImpl.findAllActive();
    }

}
