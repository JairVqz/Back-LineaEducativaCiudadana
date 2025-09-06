package mx.gob.sev.api.LineaEducativaCiudadana.Usuario.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import mx.gob.sev.api.LineaEducativaCiudadana.Usuario.Models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
     //activos
    @Query("SELECT c FROM Usuario c WHERE c.activo = 1 ORDER BY c.id")
    List<Usuario> findAllActive();

    //inactivos
    @Query("SELECT c FROM Usuario c WHERE c.activo = 0 ORDER BY c.id")
    List<Usuario> findAllInactive();

    //por id
    @Query("SELECT c FROM Usuario c WHERE c.id = :id")
    Optional<Usuario> findById(@Param("id") Long id);

    //inicio de sesion
    @Query("SELECT c FROM Usuario c WHERE c.email = :email AND c.activo = 1")
    Optional<Usuario> validateLogin(@Param("email") String email);

}
