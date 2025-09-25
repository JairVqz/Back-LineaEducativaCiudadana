package mx.gob.sev.api.LineaEducativaCiudadana.Usuario.Services.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import mx.gob.sev.api.LineaEducativaCiudadana.Usuario.Models.Usuario;
import mx.gob.sev.api.LineaEducativaCiudadana.Usuario.Models.VistaUsuario;
import mx.gob.sev.api.LineaEducativaCiudadana.Usuario.Repositories.UsuarioRepository;

@Service
public class UsuarioImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> findAll() {
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
    public Usuario findById(Long id) {
        return this.usuarioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado: " + id));
    }

    @Override
    public Usuario save(Usuario usuario) {
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
    public Usuario update(Usuario usuario) {
        Optional<Usuario> usuarioOptional = this.usuarioRepository.findById(usuario.getIdUsuario());

        if (usuarioOptional.isPresent()) {
            Usuario usuarioExistente = usuarioOptional.get();
            usuarioExistente.setNombre(usuario.getNombre());
            usuarioExistente.setCurp(usuario.getCurp());
            usuarioExistente.setEmail(usuario.getEmail());
            usuarioExistente.setRol(usuario.getRol());
            usuarioExistente.setActivo(usuario.getActivo());

            return this.usuarioRepository.save(usuarioExistente);
        }
        throw new RuntimeException("Usuario no encontrado: " + usuario.getIdUsuario());
    }

    @Override
    public List<VistaUsuario> findAllVistaU() {
        List<Object[]> resultados = usuarioRepository.findAllVistaU();
        List<VistaUsuario> lista = new ArrayList<>();
        for (Object[] fila : resultados) {
            // usuario
            Number idUsuarioNum = (Number) fila[0];
            String nombreSt = (String) fila[1];
            String curpSt = (String) fila[2];
            String emailSt = (String) fila[3];
            Number idRolNum = (Number) fila[4];
            String rolSt = (String) fila[5];
            Number activoNum = (Number) fila[6];
            // area
            Number idDirectorioNum = (Number) fila[7];
            Number idAreaNum = (Number) fila[8];
            String nombreAreaSt = (String) fila[9];
            Number idInternoAreaNum = (Number) fila[10];
            String nombreAreaInternaSt = (String) fila[11];
            // tramite
            Number idTramiteNum = (Number) fila[12];
            String nombreTramiteSt = (String) fila[13];
            // extension
            Number idExtensionNum = (Number) fila[14];
            String extensionSt = (String) fila[15];
            String responsableSt = (String) fila[16];

            // usuario
            Long idUsuario = idUsuarioNum != null ? idUsuarioNum.longValue() : null;
            String nombre = nombreSt != null ? nombreSt : null;
            String curp = curpSt != null ? curpSt : null;
            String email = emailSt != null ? emailSt : null;
            Long idRol = idRolNum != null ? idRolNum.longValue() : null;
            String rol = rolSt != null ? rolSt : null;
            Long activo = activoNum != null ? activoNum.longValue() : null;
            // area
            Long idDirectorio = idDirectorioNum != null ? idDirectorioNum.longValue() : null;
            Long idArea = idAreaNum != null ? idAreaNum.longValue() : null;
            String nombreArea = nombreAreaSt != null ? nombreAreaSt : null;
            Long idInterno = idInternoAreaNum != null ? idInternoAreaNum.longValue() : null;
            String nombreAreaInterna = nombreAreaInternaSt != null ? nombreAreaInternaSt : null;
            // tramite
            Long idTramite = idTramiteNum != null ? idTramiteNum.longValue() : null;
            String nombreTramite = nombreTramiteSt != null ? nombreTramiteSt : null;
            // extension
            Long idExtension = idExtensionNum != null ? idExtensionNum.longValue() : null;
            String extension = extensionSt != null ? extensionSt : null;
            String responsable = responsableSt != null ? responsableSt : null;

            lista.add(new VistaUsuario(
                    idUsuario,
                    nombre,
                    curp,
                    email,
                    idRol,
                    rol,
                    activo,
                    idDirectorio,
                    idArea,
                    nombreArea,
                    idInterno,
                    nombreAreaInterna,
                    idTramite,
                    nombreTramite,
                    idExtension,
                    extension,
                    responsable));
        }
        return lista;
    }

    public List<Usuario> findAllConAccesos() {
        return this.usuarioRepository.findAllConAccesos();
    }


}
