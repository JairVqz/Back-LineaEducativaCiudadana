package mx.gob.sev.api.LineaEducativaCiudadana.Usuario.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import mx.gob.sev.api.LineaEducativaCiudadana.Usuario.Models.Usuario;
import mx.gob.sev.api.LineaEducativaCiudadana.Usuario.Services.Usuario.UsuarioImpl;

@RestController
@RequestMapping("api/Usuario")
@CrossOrigin("*")

public class UsuarioController {

    @Autowired
    private UsuarioImpl usuarioImpl;

    @GetMapping("/findAll")
    @Transactional(readOnly = true)
    public List<Usuario> findAll(){
        return this.usuarioImpl.findAll();
    }

    @PostMapping
    @Transactional
    public Usuario save(@RequestBody Usuario usuario){
        return this.usuarioImpl.save(usuario);
    }
    
}
