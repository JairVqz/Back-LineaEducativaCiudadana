package mx.gob.sev.api.LineaEducativaCiudadana.Solicitud.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import mx.gob.sev.api.LineaEducativaCiudadana.Solicitud.Models.Contacto;
import mx.gob.sev.api.LineaEducativaCiudadana.Solicitud.Services.Contacto.ContactoImpl;

@RestController
@RequestMapping("api/Contacto")
@CrossOrigin("*")

public class ContactoController {

    @Autowired
    private ContactoImpl contactoImpl;

    @GetMapping("/findAll")
    @Transactional(readOnly = true)
    public List<Contacto> findAll(){
        return this.contactoImpl.findAll();
    }

    @PostMapping
    @Transactional
    public Contacto save(@RequestBody Contacto contacto){
        return this.contactoImpl.save(contacto);
    }
    
}
