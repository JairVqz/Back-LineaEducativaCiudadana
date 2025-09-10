package mx.gob.sev.api.LineaEducativaCiudadana.Usuario.Services.Rol;

import java.util.List;

import mx.gob.sev.api.LineaEducativaCiudadana.Usuario.Models.Rol;

public interface RolService {
    List<Rol> findAll();
    List<Rol> findAllActive();
    List<Rol> findAllInactive();
    Rol findById(Long idRol);
    Rol save(Rol usuario);
    Rol update (Rol usuario);
}
