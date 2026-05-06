package mx.gob.sev.api.LineaEducativaCiudadana.Usuario.Services.Usuario;

import java.util.List;

import mx.gob.sev.api.LineaEducativaCiudadana.Usuario.Models.Usuario;
import mx.gob.sev.api.LineaEducativaCiudadana.Usuario.Models.VistaUsuario;

public interface UsuarioService {

    List<Usuario> findAll();

    List<Usuario> findAllActive();

    List<Usuario> findAllInactive();

    Usuario findById(Long id);

    Usuario save(Usuario usuario);

    Usuario update(Usuario usuario);

    Usuario validateLogin(String email);

    List<VistaUsuario> findAllVistaU();

    List<Usuario> findAllActiveConAccesos();

    List<Usuario> findAllInactiveConAccesos();

    List<Usuario> findAllActiveConAccesosSupervisor(Long idArea);

    List<Usuario> findAllInactiveConAccesosSupervisor(Long idArea);

    void reactivateById(Long id);

    void desactivateById(Long id);
}
