package mx.gob.sev.api.LineaEducativaCiudadana.Usuario.Services.RelacionAcceso;

import java.util.List;

import mx.gob.sev.api.LineaEducativaCiudadana.Usuario.Models.RelacionAcceso;

public interface RelacionAccesoService {

    List<RelacionAcceso> findAll();
    RelacionAcceso save(RelacionAcceso relacionAcceso);
    
}
