package mx.gob.sev.api.LineaEducativaCiudadana.Bitacora.Services;

import java.time.LocalDateTime;
import java.util.List;

import mx.gob.sev.api.LineaEducativaCiudadana.Bitacora.Models.Bitacora;

public interface BitacoraService {

    List<Bitacora> findAll();
    List<Object[]> findAllActiveByRange(LocalDateTime fecha_inicio, LocalDateTime fecha_fin);
    Bitacora save(Bitacora bitacora);
    
}