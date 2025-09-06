package mx.gob.sev.api.LineaEducativaCiudadana.Usuario.Services.Rol;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import mx.gob.sev.api.LineaEducativaCiudadana.Usuario.Models.Rol;
import mx.gob.sev.api.LineaEducativaCiudadana.Usuario.Repositories.RolRepository;

@Service
public class RolImpl implements RolService {
    @Autowired
    private RolRepository repo;

    @Override
    public List<Rol> findAll() {
        return (List<Rol>) this.repo.findAll();
    }

    @Override
    public List<Rol> findAllActive() {
        return (List<Rol>) this.repo.findAllActive();
    }

    @Override
    public List<Rol> findAllInactive() {
        return (List<Rol>) this.repo.findAllInactive();
    }

    @Override
    public Rol findById(Long idRol) {
        return this.repo.findById(idRol).orElseThrow(() -> new EntityNotFoundException("Rol no encontrado: " + idRol));
    }

    @Override
    public Rol save(Rol rol) {
        return this.repo.save(rol);
    }

    @Override
    public Rol update(Rol rol) {
        Optional<Rol> rolOptional = this.repo.findById(rol.getIdRol());
        if (rolOptional.isPresent()) {
            Rol rolExistente = rolOptional.get();
            rolExistente.setRol(rol.getRol());
            rolExistente.setActivo(rol.getActivo());
            return this.repo.save(rolExistente);
        }
        throw new RuntimeException("Rol no encontrado: " + rol.getIdRol());
    }

}
