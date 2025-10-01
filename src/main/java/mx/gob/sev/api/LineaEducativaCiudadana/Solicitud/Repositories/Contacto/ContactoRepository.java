package mx.gob.sev.api.LineaEducativaCiudadana.Solicitud.Repositories.Contacto;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.gob.sev.api.LineaEducativaCiudadana.Solicitud.Models.Contacto.Contacto;

public interface ContactoRepository extends JpaRepository<Contacto, Long>{
    
}
