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
        if (usuario.getRelacionAcceso() != null) {
            usuario.getRelacionAcceso().forEach(rel -> {
                rel.setUsuario(usuario);
            });
        }
        return usuarioRepository.save(usuario);
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
            Number idAreaUsuarioNum = (Number) fila[7];
            Number idDirectorioNum = (Number) fila[8];
            Number idAreaDirectorioNum = (Number) fila[9];
            String nombreAreaSt = (String) fila[10];
            Number idInternoAreaNum = (Number) fila[11];
            String nombreAreaInternaSt = (String) fila[12];
            // tramite
            Number idTramiteNum = (Number) fila[13];
            String nombreTramiteSt = (String) fila[14];
            // extension
            Number idExtensionNum = (Number) fila[15];
            String extensionSt = (String) fila[16];
            String responsableSt = (String) fila[17];
            Number idAreaFinalNum = (Number) fila[18];

            // usuario
            Long idUsuario = idUsuarioNum != null ? idUsuarioNum.longValue() : null;
            String nombre = nombreSt != null ? nombreSt : null;
            String curp = curpSt != null ? curpSt : null;
            String email = emailSt != null ? emailSt : null;
            Long idRol = idRolNum != null ? idRolNum.longValue() : null;
            String rol = rolSt != null ? rolSt : null;
            Long activo = activoNum != null ? activoNum.longValue() : null;
            // area
            Long idAreaUsuario = idAreaUsuarioNum != null ? idAreaUsuarioNum.longValue() : null;
            Long idDirectorio = idDirectorioNum != null ? idDirectorioNum.longValue() : null;
            Long idAreaDirectorio = idAreaDirectorioNum != null ? idAreaDirectorioNum.longValue() : null;
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
            Long idAreaFinal = idAreaFinalNum != null ? idAreaFinalNum.longValue() : null;

            lista.add(new VistaUsuario(
                    idUsuario,
                    nombre,
                    curp,
                    email,
                    idRol,
                    rol,
                    activo,
                    idAreaUsuario, 
                    idDirectorio,
                    idAreaDirectorio,
                    nombreArea,
                    idInterno,
                    nombreAreaInterna,
                    idTramite,
                    nombreTramite,
                    idExtension,
                    extension,
                    responsable, 
                    idAreaFinal
                ));
        }
        return lista;
    }

    public List<Usuario> findAllActiveConAccesos() {
        return this.usuarioRepository.findAllActiveConAccesos();
    }   

    public List<Usuario> findAllInactiveConAccesos() {
        return this.usuarioRepository.findAllInactiveConAccesos();
    }

    @Override
    public void reactivateById(Long idSuministro) {
        Optional<Usuario> suministro = this.usuarioRepository.findById(idSuministro);
        if (suministro.isPresent()) {
            this.usuarioRepository.reactivateById(idSuministro);
        } else {
            throw new RuntimeException("Usuario no encontrado con el id: " + idSuministro);
        }
    }

    @Override
    public void desactivateById(Long idSuministro) {
        Optional<Usuario> suministro = this.usuarioRepository.findById(idSuministro);
        if (suministro.isPresent()) {
            this.usuarioRepository.desactivateById(idSuministro);
        } else {
            throw new RuntimeException("Usuario no encontrado con el id: " + idSuministro);
        }
    }

}
