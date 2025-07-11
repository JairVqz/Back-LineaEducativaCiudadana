package mx.gob.sev.api.LineaEducativaCiudadana.Solicitud.Services.Contacto;

import java.util.List;

import mx.gob.sev.api.LineaEducativaCiudadana.Solicitud.Models.Contacto;

public interface ContactoService {   

    List<Contacto> findAll();
    Contacto save(Contacto contacto);

}
