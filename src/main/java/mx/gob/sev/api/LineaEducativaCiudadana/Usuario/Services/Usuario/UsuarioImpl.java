package mx.gob.sev.api.LineaEducativaCiudadana.Usuario.Services.Usuario;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
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
    public List<Usuario> findAllActive() {
        return (List<Usuario>) this.usuarioRepository.findAllActive();
    }

    @Override
    public List<Usuario> findAllInactive() {
        return (List<Usuario>) this.usuarioRepository.findAllInactive();
    }

    @Override
    public Usuario findById(Long id){
        return this.usuarioRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado: " + id));
    }

    @Override
    public Usuario save(Usuario usuario){
        return this.usuarioRepository.save(usuario);
    }

    @Override
    public Usuario validateLogin(String email) {
        Optional<Usuario> usuario = this.usuarioRepository.validateLogin(email);
        if (usuario.isPresent()) {
            return usuario.get();
        } else {
            throw new EntityNotFoundException("Usuario no encontrado con los datos proporcionados");
        }
    }

    @Override
    public Usuario update(Usuario usuario){
        Optional<Usuario> usuarioOptional = this.usuarioRepository.findById(usuario.getId());

        if(usuarioOptional.isPresent()){
            Usuario usuarioExistente = usuarioOptional.get();
            usuarioExistente.setNombre(usuario.getNombre());
            usuarioExistente.setCurp(usuario.getCurp());
            usuarioExistente.setEmail(usuario.getEmail());
            usuarioExistente.setRol(usuario.getRol());
            usuarioExistente.setRelacionAcceso(usuario.getRelacionAcceso());
            usuarioExistente.setActivo(usuario.getActivo());

            return this.usuarioRepository.save(usuarioExistente);
        }
        throw new RuntimeException("Usuario no encontrado: " + usuario.getId());
    }
    
}
