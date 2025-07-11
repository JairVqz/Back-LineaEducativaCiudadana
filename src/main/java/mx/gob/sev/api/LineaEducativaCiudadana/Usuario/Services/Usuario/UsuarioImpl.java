package mx.gob.sev.api.LineaEducativaCiudadana.Usuario.Services.Usuario;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.gob.sev.api.LineaEducativaCiudadana.Usuario.Models.Usuario;
import mx.gob.sev.api.LineaEducativaCiudadana.Usuario.Repositories.UsuarioRepository;

@Service
public class UsuarioImpl implements UsuarioService{

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> findAll(){
        return (List<Usuario>) this.usuarioRepository.findAll();
    }

    @Override
    public Usuario save(Usuario usuario){
        return this.usuarioRepository.save(usuario);
    }
    
}
