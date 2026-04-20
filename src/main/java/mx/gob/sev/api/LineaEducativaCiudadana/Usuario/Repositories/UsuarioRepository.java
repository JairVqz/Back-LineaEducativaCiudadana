package mx.gob.sev.api.LineaEducativaCiudadana.Usuario.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import mx.gob.sev.api.LineaEducativaCiudadana.Usuario.Models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // activos
    @Query("SELECT c FROM Usuario c WHERE c.activo = 1 ORDER BY c.id")
    List<Usuario> findAllActive();

    // inactivos
    @Query("SELECT c FROM Usuario c WHERE c.activo = 0 ORDER BY c.id")
    List<Usuario> findAllInactive();

    // por id
    @Query("SELECT c FROM Usuario c WHERE c.id = :id")
    Optional<Usuario> findById(@Param("id") Long id);

    // inicio de sesion
    @Query("SELECT u FROM Usuario u LEFT JOIN FETCH u.relacionAcceso WHERE u.email = :email AND u.activo=1")
    Optional<Usuario> validateLogin(@Param("email") String email);

    @Query(value = "SELECT * FROM vista_usuario ORDER BY idAreaFinal ASC", nativeQuery = true)
    List<Object[]> findAllVistaU();

    @Query("""
    SELECT u 
    FROM Usuario u 
    LEFT JOIN FETCH u.relacionAcceso ra 
    LEFT JOIN FETCH ra.directorio d 
    WHERE u.activo = 1 
    ORDER BY u.area.idArea ASC, u.rol.idRol ASC
    """)
    List<Usuario> findAllActiveConAccesos();

    @Query("""
    SELECT u 
    FROM Usuario u 
    LEFT JOIN FETCH u.relacionAcceso ra 
    LEFT JOIN FETCH ra.directorio d 
    WHERE u.activo = 0 
    ORDER BY u.area.idArea ASC, u.rol.idRol ASC
    """)    
    List<Usuario> findAllInactiveConAccesos();

    @Modifying
    @Query("UPDATE Usuario u SET u.activo = 1 WHERE u.id = :id")
    void reactivateById(@Param("id") Long id);

    @Modifying
    @Query("UPDATE Usuario u SET u.activo = 0 WHERE u.id = :id")
    void desactivateById(@Param("id") Long id);

}
