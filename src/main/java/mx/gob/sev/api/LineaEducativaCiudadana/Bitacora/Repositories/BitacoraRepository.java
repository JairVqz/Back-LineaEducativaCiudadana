package mx.gob.sev.api.LineaEducativaCiudadana.Bitacora.Repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import mx.gob.sev.api.LineaEducativaCiudadana.Bitacora.Models.Bitacora;

public interface BitacoraRepository extends JpaRepository<Bitacora, Long> {

    /*@Query(value = "SELECT * FROM tbl_bitacora WHERE activo=1 AND CAST(fecha AS DATE) BETWEEN :fecha_inicio AND :fecha_fin ORDER BY idBitacora", nativeQuery = true)
    List<Bitacora> findAllActiveByRange(@Param("fecha_inicio") String fecha_inicio,
            @Param("fecha_fin") String fecha_fin);*/

    @Query("SELECT  b.idBitacora, b.idEntidad, b.entidad, b.accion, b.usuario.nombre, b.fecha " +
            "FROM Bitacora b WHERE b.activo = 1 AND b.fecha BETWEEN :fecha_inicio AND :fecha_fin ORDER BY b.idBitacora")
    List<Object[]> findAllActiveByRange(@Param("fecha_inicio") LocalDateTime fecha_inicio,
            @Param("fecha_fin") LocalDateTime fecha_fin);

}
