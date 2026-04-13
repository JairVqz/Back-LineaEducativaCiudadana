package mx.gob.sev.api.LineaEducativaCiudadana.Usuario.Services.RelacionAcceso;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import mx.gob.sev.api.LineaEducativaCiudadana.Usuario.Models.RelacionAcceso;
import mx.gob.sev.api.LineaEducativaCiudadana.Usuario.Repositories.RelacionAccesoRepository;

@Service
public class RelacionAccesoImpl implements RelacionAccesoService {

    @Autowired
    private RelacionAccesoRepository relacionAccesoRepository;

    @Override
    public List<RelacionAcceso> findAll() {
        return (List<RelacionAcceso>) this.relacionAccesoRepository.findAll();
    }

    @Override
    public RelacionAcceso save(RelacionAcceso relacionAcceso) {
        return this.relacionAccesoRepository.save(relacionAcceso);
    }

    @Override
    public List<RelacionAcceso> findDirectorioByUsuario(Long idUsuario) {
        return (List<RelacionAcceso>) this.relacionAccesoRepository.findDirectorioByUsuario(idUsuario);
    }

    @Override
    public void desasignarTramite(Long idAcceso) {
        Optional<RelacionAcceso> relacion = this.relacionAccesoRepository.findById(idAcceso);
        if (relacion.isPresent()) {
            this.relacionAccesoRepository.desasignarTramite(idAcceso);
        } else {
            throw new EntityNotFoundException("RelacionAcceso con ID " + idAcceso + " no encontrado.");
        }
    }

}
