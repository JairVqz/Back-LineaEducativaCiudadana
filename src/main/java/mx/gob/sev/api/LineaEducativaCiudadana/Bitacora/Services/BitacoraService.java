package mx.gob.sev.api.LineaEducativaCiudadana.Bitacora.Services;

import java.util.List;

import mx.gob.sev.api.LineaEducativaCiudadana.Bitacora.Models.Bitacora;

public interface BitacoraService {

    List<Bitacora> findAll();
    Bitacora save(Bitacora bitacora);
    
}