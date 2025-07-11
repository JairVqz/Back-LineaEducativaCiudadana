package mx.gob.sev.api.LineaEducativaCiudadana.Usuario.Services.Usuario;

import java.util.List;

import mx.gob.sev.api.LineaEducativaCiudadana.Usuario.Models.Usuario;

public interface UsuarioService {

    List<Usuario> findAll();
    Usuario save(Usuario usuario);
    
}
