package mx.gob.sev.api.LineaEducativaCiudadana.Estatus.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import mx.gob.sev.api.LineaEducativaCiudadana.Estatus.Models.Estatus;

public interface EstatusRepository extends JpaRepository<Estatus, Long> {
    // activos
    @Query("SELECT c FROM Estatus c WHERE c.activo = 1 ORDER BY c.idEstatus ASC")
    List<Estatus> findAllActive();
}