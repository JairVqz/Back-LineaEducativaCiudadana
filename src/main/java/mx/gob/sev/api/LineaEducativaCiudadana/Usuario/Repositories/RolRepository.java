package mx.gob.sev.api.LineaEducativaCiudadana.Usuario.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import mx.gob.sev.api.LineaEducativaCiudadana.Usuario.Models.Rol;

public interface RolRepository extends JpaRepository<Rol, Long> {

    // activos
    @Query("SELECT c FROM Rol c WHERE c.activo = 1 ORDER BY c.idRol")
    List<Rol> findAllActive();

    // inactivos
    @Query("SELECT c FROM Rol c WHERE c.activo = 0 ORDER BY c.idRol")
    List<Rol> findAllInactive();

    // por id
    @Query("SELECT c FROM Rol c WHERE c.idRol = :idRol")
    Optional<Rol> findById(@Param("idRol") Long idRol);

}
